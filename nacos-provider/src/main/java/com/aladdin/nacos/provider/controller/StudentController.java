package com.aladdin.nacos.provider.controller;

import com.aladdin.nacos.provider.common.Result;
import com.aladdin.nacos.provider.service.StudentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public Result studentPageList(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page page = new Page(pageNo, pageSize);
        return Result.renderOk(studentService.pageList(page));
    }
}
