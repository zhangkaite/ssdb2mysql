package com.okay.praxisservice.dao.mapper;

import com.okay.praxisservice.entity.SqlParamEntity;
import com.okay.praxisservice.entity.StudentExcise;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kate on 2016/12/19.
 */
@Repository
public interface StudentExerciseMapper {

    void updateData(List<StudentExcise> list);

    List<StudentExcise> selectData(SqlParamEntity entity);

    Integer getDataNum(SqlParamEntity entity);

}
