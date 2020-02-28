package com.aladdin.bootdubbo.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Component
@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<String> bookList() {
        return Arrays.asList("人性的枷锁", "计算机组成原理");
    }
}
