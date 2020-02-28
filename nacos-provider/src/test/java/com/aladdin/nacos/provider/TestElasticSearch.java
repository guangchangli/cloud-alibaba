package com.aladdin.nacos.provider;

import io.searchbox.client.JestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lgc
 * @create 2020-02-28
 **/
@SpringBootTest
public class TestElasticSearch {

    @Autowired
    JestClient jestClient;
//    @Test
//    public void test() throws IOException {
//        Book book = Book.builder().id(1).author("毛姆").bookName("人性的枷锁").price("60.0").build();
//        Index index = new Index.Builder(book).index("lgc").type("books").build();
//        jestClient.execute(index);
//    }
//    @Test
//    public void search(){
//        String json="{\n" +
//                "\t\"query\":{\n" +
//                "\t\t\"match\":{\n" +
//                "\t\t\t\"content\":\"人性\"\n" +
//                "\t\t}\n" +
//                "\t}\n" +
//                "}";
//        Search build = new Search.Builder(json).addIndex("lgc").addType("books").build();
//        try {
//            SearchResult searchResult = jestClient.execute(build);
//            System.out.println(searchResult);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
