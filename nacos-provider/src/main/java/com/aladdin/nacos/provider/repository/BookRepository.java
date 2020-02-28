package com.aladdin.nacos.provider.repository;

import com.aladdin.nacos.provider.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author lgc
 * @create 2020-02-28
 **/

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    //参照
    List<Book> findByBookNameLike(String bookName);
}
