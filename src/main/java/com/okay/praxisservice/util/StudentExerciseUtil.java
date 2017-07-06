package com.okay.praxisservice.util;

import com.noriental.utils.ssdb.SSDBUtil;
import com.okay.praxisservice.entity.StudentExcise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kate on 2017/6/30.
 */
public class StudentExerciseUtil {
    public static String ANSWER_SHORT_KEY = "answer";
    public static String RESULT_SHORT_KEY = "r";
    public static final String ROLR_SHORT_KEY = "c";
    public static final String POSTIL_SHORT_KEY = "postil";
    public static final String POSTIL_SVG_FLAG = "new";
    public static final String INTELL_CORRECT_RESULT = "intellCorrect_result_";
    public static final String INTELL_POSTIL_RESULT = "intellPostil_";
    public static final String INTELL_CORRECT_RESOURCE = "intellCorrect_resource_";

    public static final String GET_SSDB_KYE_PRE(StudentExcise se) {
        return "se" + se.getExerciseSource() + "_" + se.getResourceId() + "_" + se.getStudentId() + "_" + se
                .getQuestionId();
    }

    public static final String GET_SSDB_KYE_AFTER(StudentExcise se) {
        return  se.getExerciseSource() + "_" + se.getResourceId() + "_" + se.getStudentId() + "_" + se
                .getQuestionId();
    }


    public static Map<String, String> getFromSsdb(SSDBUtil ssdbUtil, StudentExcise se) {
        List<String> keys = getKeysByStuExe(se);
        return ssdbUtil.mget(keys);
    }

    private static List<String> getKeysByStuExe(StudentExcise se) {
        List<String> list = new ArrayList<String>();
        String key_p = GET_SSDB_KYE_PRE(se);
        String key_after=GET_SSDB_KYE_AFTER(se);
        list.add(key_p + ROLR_SHORT_KEY);
        list.add(key_p + RESULT_SHORT_KEY);
        list.add(key_p + ANSWER_SHORT_KEY);
        list.add(key_p + POSTIL_SHORT_KEY);
        list.add(key_p + POSTIL_SVG_FLAG);
        list.add(INTELL_CORRECT_RESULT + key_after);
        list.add(INTELL_POSTIL_RESULT + key_after);
        list.add(INTELL_CORRECT_RESOURCE + key_after);
        return list;
    }

}
