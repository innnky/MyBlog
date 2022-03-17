package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.innky.bootproj.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getAllArticle(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    List<Article> getRecentArticles(int len);

    Article getArticle(Integer aid);

    Integer addArticle(Article article);

    Integer deleteArticle(Article article);

    Integer queryArticleNums();
}
