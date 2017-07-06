package com.okay.praxisservice;

import com.okay.praxisservice.service.interfaces.StudentExerciseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by kate on 2017/2/22.
 * 思路：以main方法为入口启动spring容器，
 * 批量更新调用方法入口
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
