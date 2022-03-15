package xyz.innky.bootproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.dto.DtoArticle;
import xyz.innky.bootproj.dto.Inf;
import xyz.innky.bootproj.mapper.ArticleMapper;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.mapper.InfoMapper;
import xyz.innky.bootproj.pojo.Article;
import xyz.innky.bootproj.pojo.Info;

import java.util.*;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    DirMapper dirMapper;

    @Autowired
    InfoMapper infoMapper;
    public List<DtoArticle> getRecentArticles() {
        List<Article> articles = articleMapper.getRecentArticles(3);
        List<DtoArticle> dtoArticles = new ArrayList<>();
        for (Article article : articles) {
            dtoArticles.add(new DtoArticle(article.getTitle(),article.getId().toString()));
        }
        return dtoArticles;
    }

    public List<String> getRecentTypes() {

        return dirMapper.getRecentTypes(3);
    }

    public List<Inf> getInfos() {
        List<Info> infos = infoMapper.getInfos();
        List<Inf> res = new ArrayList<>();
        for (Info info : infos) {
            res.add(new Inf(info.getName(),info.getId().toString(),info.getDescription(), info.getImageUrl()));
        }
        return res;
    }
}
