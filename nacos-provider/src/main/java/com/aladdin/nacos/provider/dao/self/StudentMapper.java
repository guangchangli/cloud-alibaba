package com.aladdin.nacos.provider.dao.self;

import com.aladdin.nacos.provider.entity.self.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lgc
 **/
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<Student> studentList();
}
