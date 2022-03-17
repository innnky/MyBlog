package xyz.innky.bootproj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.innky.bootproj.controller.ArticleController;
import xyz.innky.bootproj.mapper.ArticleMapper;

@SpringBootTest
class BootProjApplicationTests {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleController articleController;

    @Test
    void contextLoads() {
        String dir = "asdasd.ddd";
        System.out.println(dir.lastIndexOf("/"));
    }
    @Test
    void testGetAllArticle(){
        System.out.println(articleController.getAllArticle(1, 3));
    }

}
