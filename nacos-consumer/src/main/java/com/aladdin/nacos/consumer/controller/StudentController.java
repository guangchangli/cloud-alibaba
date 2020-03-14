package com.aladdin.nacos.consumer.controller;

import com.aladdin.nacos.consumer.feign.StudentService;
import com.aladdin.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author lgc
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/list/plus")
    public Result studentPageList(@RequestParam int pageNo, @RequestParam int pageSize) {
        Page page = new Page(pageNo, pageSize);
        return Result.renderOk(studentService.pageListPlus(page));
    }
    @GetMapping("/list")
    public Result studentPageListPlus(@RequestParam int pageNo, @RequestParam int pageSize) {
        System.out.println("---");
        Page page = new Page(pageNo, pageSize);
        return Result.renderOk(studentService.pageList(page));
    }
}
