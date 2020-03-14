package com.aladdin.nacos.consumer.feedback;

import com.aladdin.nacos.consumer.feign.StudentService;
import com.aladdin.response.Result;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.debugger.Page;

/**
 * @author lgc
 **/
@Component
public class StudentFallBack implements StudentService {

    static Result resp = new Result();

    static {
        Result.renderOk("当前访问人数较多，请稍后访问");
    }

    @Override
    public Result pageListPlus(Page page) {

        return resp;
    }

    @Override
    public Result pageList(Page page) {
        return resp;
    }
}
