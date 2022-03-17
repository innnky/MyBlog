package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.innky.bootproj.dto.DtoArticle;
import xyz.innky.bootproj.dto.IndexInformationVO;
import xyz.innky.bootproj.dto.Inf;
import xyz.innky.bootproj.service.ArticleService;
import xyz.innky.bootproj.service.DirectoryService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "null"})
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    DirectoryService directoryService;

    @GetMapping("/indexInformation")
    public IndexInformationVO getIndexInformation(){
        IndexInformationVO indexInformationVO = new IndexInformationVO();
        indexInformationVO.setPersonalInf(articleService.getInfos());
        indexInformationVO.setRecentArticles(articleService.getRecentArticles());
        indexInformationVO.setTypes(directoryService.getRecentTypes());
        return indexInformationVO;
    }

    @GetMapping("/article/{aid}")
    public DtoArticle article(@PathVariable("aid") Integer aid){

        return articleService.getArticle(aid);
    }

    @GetMapping("/all/article")
    public Object getAllArticle(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize){
        Map<String, Object> map = new HashMap<>();
        List<DtoArticle> articles = articleService.getAllArticle(page, pageSize);
        Integer totalArticles = articleService.queryArticleNums();
        map.put("articles",articles);
        map.put("total", totalArticles);
        return map;
    }

    @PostMapping("/article")
    public Object insertArticle(String content,
                                String dir,
                                String title,
                                Long lastModifiedTime){
        Integer i = articleService.insertArticle(content, dir, title, lastModifiedTime);
        return i.toString();
    }

    @DeleteMapping("/article")
    public Integer deleteArticle(String title, String dir){
        return articleService.deleteArticle(title, dir);
    }



}
