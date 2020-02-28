package com.aladdin.nacos.provider.service.impl;

import com.aladdin.nacos.provider.entity.Book;
import com.aladdin.nacos.provider.repository.BookRepository;
import com.aladdin.nacos.provider.service.BookEsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Service("bookEsService")
public class BookEsServiceImpl implements BookEsService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findBookByCondition(Map map) {
        String name = (String) map.get("name");
        return bookRepository.findByBookNameLike(name);
    }

    @Override
    public void addBookBatch(String json) {
        List<Book> list = JSON.parseArray(json, Book.class);
        list.forEach(book -> bookRepository.index(book));
    }
}
