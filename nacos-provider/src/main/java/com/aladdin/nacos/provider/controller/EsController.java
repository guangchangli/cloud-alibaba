package com.aladdin.nacos.provider.controller;

import com.aladdin.nacos.provider.entity.Book;
import com.aladdin.nacos.provider.repository.BookRepository;
import com.aladdin.nacos.provider.service.BookEsService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * springboot 默认支持 两种技术和es交互
 * 1.jest 默认不生效 需要导入 io.search.client.JestClient
 * 2.SpringData ElasticSearch
 * client 节点信息 clusterNodes clusterName
 * ElasticTemplate
 * ElasticsearchRepository 子接口
 *
 * @author lgc
 * @create 2020-02-28
 **/
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    BookEsService bookEsService;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/list")
    public String bookList(@RequestParam(value = "name", required = false) String name) {
        Map<Object, Object> param = Maps.newHashMap();
        param.put("name", name);
        List<Book> list = bookEsService.findBookByCondition(param);
        return JSON.toJSONString(list);
    }

    @PutMapping("/insert")
    public HttpStatus insertBatchBook(@RequestBody String json) {
        bookEsService.addBookBatch(json);
        return HttpStatus.OK;
    }

}
