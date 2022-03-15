package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.bootproj.pojo.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getAllArticle();

    List<Article> getRecentArticles(int len);
}
