package com.aladdin.nacos.provider.service.impl;

import com.aladdin.nacos.provider.dao.self.StudentMapper;
import com.aladdin.nacos.provider.dao.self.StudentMapperPlus;
import com.aladdin.nacos.provider.entity.self.Student;
import com.aladdin.nacos.provider.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgc
 **/
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapperPlus studentMapperPlus;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public IPage<Student> pageListPlus(Page page) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        IPage<Student> iPage = studentMapperPlus.selectPage(page, queryWrapper);
        return iPage;
    }   @Override
    public List<Student> pageList(Page page) {
        List<Student> list = studentMapper.studentList();
        return list;
    }
}
