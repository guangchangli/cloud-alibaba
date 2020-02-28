package com.aladdin.consumerdubbo.Service.impl;

import com.aladdin.bootdubbo.service.dubbo.BookService;
import com.aladdin.consumerdubbo.Service.ConsumerService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Reference
    BookService bookService;

    @Override
    public List<String> consumerBook() {
        return bookService.bookList();
    }
}
