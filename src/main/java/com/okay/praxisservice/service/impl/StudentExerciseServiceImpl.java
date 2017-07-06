package com.okay.praxisservice.service.impl;

import com.noriental.utils.ssdb.SSDBUtil;
import com.okay.praxisservice.dao.mapper.StudentExerciseMapper;
import com.okay.praxisservice.entity.SqlParamEntity;
import com.okay.praxisservice.entity.StudentExcise;
import com.okay.praxisservice.service.interfaces.StudentExerciseService;
import com.okay.praxisservice.util.StudentExerciseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by kate on 2017/6/30.
 */
@Service("studentExerciseService")
public class StudentExerciseServiceImpl implements StudentExerciseService {
    private static final Logger logger = LoggerFactory.getLogger(StudentExerciseServiceImpl.class);

    @Autowired
    private SSDBUtil ssdbUtil;

    @Autowired
    private StudentExerciseMapper studentExerciseMapper;


    public void updateStudentExerciseService(String tablePrefix, int year, int startTable, int endTable) {
        updateExcutorCallable(year, tablePrefix, startTable, endTable);
    }

    /***
     * 执行表的数据批量更新
     */
    private void updateExcutorCallable(int year, String tablePrefixName, int startTable, int endTable) {
        String tablePrefix = "";
        if (tablePrefixName.startsWith("entity_student_exercise")) {
            tablePrefix = tablePrefixName+"_" + year + "_";
        } else {
            tablePrefix = tablePrefixName + "_";
        }
        for (int i = startTable; i <=endTable; i++) {
            String tableName = tablePrefix + i;
            StudentExciseExcutorCallable callable = new StudentExciseExcutorCallable(tableName);
            callable.start();
        }
    }

    /***
     * 具体的执行数据库批量操作业务处理
     */
    class StudentExciseExcutorCallable extends Thread {

        private String tableName;

        public StudentExciseExcutorCallable(String tableName) {
            this.tableName = tableName;
        }


        public void run() {
            Long startTime = System.currentTimeMillis();
            Thread t = Thread.currentThread();
            logger.info("===============[" + new Date() + "线程ID:" + t.getId() + ";线程名称:" + t.getName() +
                    "启动成功]===============");
            int pageSize = 200;
            // int pageNum = getPageNum(tableName, pageSize);
            boolean flag = true;
            while (flag) {
                logger.info("表:" + tableName + ";pageSize:" + pageSize);
                List<StudentExcise> dataList = getDataList(tableName, 0, pageSize);
                if (dataList.size() == 0) {
                    flag = false;
                    t.interrupt();
                    logger.info("线程名称:" + t.getName() + "被终止");

                }
                updateData(dataList, tableName);
            }
            Long endTime = System.currentTimeMillis();
            logger.info("单个线程批量更新学生做答数据数据花费的时间:" + (endTime - startTime));

        }
    }




    /***
     * 分页查询某张表的数据
     * @param tableName
     * @param startNum
     * @param size
     * @return
     */
    private List<StudentExcise> getDataList(String tableName, int startNum, int size) {
        SqlParamEntity entity = new SqlParamEntity();
        entity.setSize(size);
        entity.setStartNum(startNum);
        entity.setTableName(tableName);
        List<StudentExcise> dataList = studentExerciseMapper.selectData(entity);
        return dataList;
    }


    /***
     * 单条数据的更新
     * @param studentExciseList
     */

    private void updateData(List<StudentExcise> studentExciseList, String tableName) {
        List<StudentExcise> list = new ArrayList<StudentExcise>();
        for (StudentExcise studentExcise : studentExciseList) {
            //获取ssdb的数据
            Map<String, String> map = StudentExerciseUtil.getFromSsdb(ssdbUtil, studentExcise);
            String key_p = StudentExerciseUtil.GET_SSDB_KYE_PRE(studentExcise);
            String result = map.get(key_p + StudentExerciseUtil.RESULT_SHORT_KEY);
            String postil = map.get(key_p + StudentExerciseUtil.POSTIL_SHORT_KEY);
            String answer = map.get(key_p + StudentExerciseUtil.ANSWER_SHORT_KEY);
            String role = map.get(key_p + StudentExerciseUtil.ROLR_SHORT_KEY);
            String svgFlag = map.get(key_p + StudentExerciseUtil.POSTIL_SVG_FLAG);
            String key_a = StudentExerciseUtil.GET_SSDB_KYE_PRE(studentExcise);
            String intell_result = map.get(StudentExerciseUtil.INTELL_CORRECT_RESULT + key_a);
            String intell_postil = map.get(StudentExerciseUtil.INTELL_POSTIL_RESULT + key_a);
            String intell_resource = map.get(StudentExerciseUtil.INTELL_CORRECT_RESOURCE + key_a);
            studentExcise.setResult(result);
            studentExcise.setPostilTeacher(postil);
            studentExcise.setSubmitAnswer(answer);
            studentExcise.setCorrectorRole(role);
            studentExcise.setPostilSvgFlag(svgFlag);
            studentExcise.setFlag(1);
            studentExcise.setTableName(tableName);
            if (tableName.startsWith("entity_student_exercise")) {
                studentExcise.setIntellPostil(intell_postil);
                studentExcise.setIntellResult(intell_result);
                studentExcise.setIntellResource(intell_resource);
            }
            list.add(studentExcise);
        }
        //studentExerciseMapper.updateData(list);
        if (list.size() > 0) {
            List<List<StudentExcise>> resultList = spliceArrays(list, 100);
            for (List<StudentExcise> dataList : resultList) {
                UpdateThread updateThread = new UpdateThread(dataList);
                new Thread(updateThread).start();
            }

        }


    }

    class UpdateThread implements Runnable {
        private List<StudentExcise> dataList;

        public UpdateThread(List<StudentExcise> dataList) {
            this.dataList = dataList;
        }

        public void run() {
            studentExerciseMapper.updateData(dataList);
        }
    }

    /**
     * 将数组根据要拆分的数据大小拆分成多个数组
     *
     * @param datas
     * @param splitSize
     * @return
     */
    private <T> List<List<T>> spliceArrays(List<T> datas, int splitSize) {
        if (datas == null || splitSize < 1) {
            return null;
        }
        int totalSize = datas.size();
        int count = (totalSize % splitSize == 0) ? (totalSize / splitSize) : (totalSize / splitSize + 1);
        List<List<T>> rows = new ArrayList<List<T>>();
        for (int i = 0; i < count; i++) {
            List<T> cols = datas.subList(i * splitSize, (i == count - 1) ? totalSize : splitSize * (i + 1));
            rows.add(cols);
        }
        return rows;
    }


}
