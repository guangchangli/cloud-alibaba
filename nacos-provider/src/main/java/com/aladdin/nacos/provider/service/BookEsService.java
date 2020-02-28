package com.aladdin.nacos.provider.service;

import com.aladdin.nacos.provider.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * @author lgc
 * @create 2020-02-28
 **/
public interface BookEsService {

    List<Book> findBookByCondition(Map map);

    void addBookBatch(String json);
}
