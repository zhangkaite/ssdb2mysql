package com.okay.praxisservice;

import com.okay.praxisservice.service.interfaces.StudentExerciseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kate on 2017/2/22.
 * 思路：以main方法为入口启动spring容器，
 * 批量更新调用方法入口
 * <p>
 * java -jar ssdb2Mysql-1.0.jar entity_student_exercise 2015 0 49 &
 * java -jar ssdb2Mysql-1.0.jar entity_student_exercise 2016 0 49 &
 * java -jar ssdb2Mysql-1.0.jar entity_student_exercise  2017 0 49 &
 * java -jar ssdb2Mysql-1.0.jar entity_student_exercise  2018 0 49 &
 * <p>
 * java -jar ssdb2Mysql-1.0.jar entity_student_error_exe 2015 0 49 &
 * java -jar ssdb2Mysql-1.0.jar entity_student_error_exe 2015 50 99 &
 */
public class Main {

    public static void main(String[] args) throws Exception {


        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        StudentExerciseService studentExerciseService = (StudentExerciseService) context.getBean
                ("studentExerciseService");
        studentExerciseService.updateStudentExerciseService(args[0], Integer.valueOf(args[1]), Integer.valueOf
                (args[2]), Integer.valueOf(args[3]));


    }
}
