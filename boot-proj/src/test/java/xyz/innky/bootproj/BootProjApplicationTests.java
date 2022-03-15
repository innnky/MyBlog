package xyz.innky.bootproj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.innky.bootproj.mapper.ArticleMapper;

@SpringBootTest
class BootProjApplicationTests {

    @Autowired
    ArticleMapper articleMapper;
    @Test
    void contextLoads() {
        System.out.println(articleMapper.getAllArticle());
    }

}
