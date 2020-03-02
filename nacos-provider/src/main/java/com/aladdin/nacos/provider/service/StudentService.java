package com.aladdin.nacos.provider.service;

import com.aladdin.nacos.provider.entity.self.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author lgc
 **/
public interface StudentService {

    IPage<Student> pageList(Page page);
}
