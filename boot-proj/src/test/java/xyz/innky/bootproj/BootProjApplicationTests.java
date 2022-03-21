package xyz.innky.bootproj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.innky.bootproj.controller.ArticleController;
import xyz.innky.bootproj.mapper.ArticleMapper;
import xyz.innky.bootproj.service.CommentService;
import xyz.innky.bootproj.service.DirectoryService;
import xyz.innky.bootproj.service.PlanService;

@SpringBootTest
class BootProjApplicationTests {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleController articleController;

    @Autowired
    CommentService commentService;

    @Autowired
    DirectoryService directoryService;

    @Autowired
    PlanService planService;
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

    @Test
    void testGetAllDirs(){
        directoryService.getAllDirs();
    }
    @Test
    void testProcessName(){
        System.out.println(directoryService.processName("/a/sads/"));
    }

    @Test
    void testPlanDto(){
        planService.getAllPlans();
    }
    @Test
    void testUpdatePlan(){
        planService.updateStatus("1,2,3,");
    }
}
