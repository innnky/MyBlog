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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ArticleService {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    InfoMapper infoMapper;
    public List<DtoArticle> getRecentArticles() {
        List<Article> articles = articleMapper.getRecentArticles(3);
        List<DtoArticle> dtoArticles = new ArrayList<>();
        for (Article article : articles) {
            DtoArticle article1 = new DtoArticle(article.getTitle(),article.getId().toString());
            article1.setDate(dateFormat.format(new Date(article.getLastModificationTime())));
            dtoArticles.add(article1);

        }
        return dtoArticles;
    }


    public List<Inf> getInfos() {
        List<Info> infos = infoMapper.getInfos();
        List<Inf> res = new ArrayList<>();
        for (Info info : infos) {
            res.add(new Inf(info.getName(),info.getId().toString(),info.getDescription(), info.getImageUrl()));
        }
        return res;
    }

    public DtoArticle getArticle(Integer aid) {
        Article article = articleMapper.getArticle(aid);
        DtoArticle article1 = new DtoArticle(article.getTitle(),article.getId().toString());
        article1.setDate(dateFormat.format(new Date(article.getLastModificationTime())));
        article1.setContent(article.getContent());
        return article1;
    }
}
