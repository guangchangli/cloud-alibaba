package com.aladdin.nacos.consumer.feign;

import com.aladdin.nacos.consumer.feedback.StudentFallBack;
import com.aladdin.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author lgc
 */
@FeignClient(value = "nacos-provider", fallback = StudentFallBack.class)
public interface StudentService {


    @GetMapping(value = "/student/list/plus")
    Result pageListPlus(Page page);

    @GetMapping(value = "/student/list/")
    Result pageList(Page page);
}