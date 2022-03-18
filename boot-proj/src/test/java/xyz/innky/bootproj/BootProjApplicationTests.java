package xyz.innky.bootproj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.innky.bootproj.controller.ArticleController;
import xyz.innky.bootproj.mapper.ArticleMapper;
import xyz.innky.bootproj.service.CommentService;

@SpringBootTest
class BootProjApplicationTests {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleController articleController;

    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
        String dir = "asdasd.ddd";
        System.out.println(dir.lastIndexOf("/"));
    }
    @Test
    void testGetAllArticle(){
        System.out.println(articleController.getAllArticle(1, 3));
    }

    @Test
    void testCommentService(){
        System.out.println(commentService.getCommentsByArticle(String.valueOf(138)));

    }
    @Test
    void testInsertComments(){
        commentService.insertComment(null, 138, "sdasdasd", "Asddd@aaa.com");

    }
}
