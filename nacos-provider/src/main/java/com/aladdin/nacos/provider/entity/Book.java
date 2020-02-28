package com.aladdin.nacos.provider.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "lgc", type = "books")
public class Book  {
    private Integer id;
    private String bookName;
    private String author;
    private String price;


}

