package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.bootproj.dto.DtoArticle;
import xyz.innky.bootproj.dto.IndexInformationVO;
import xyz.innky.bootproj.dto.Inf;
import xyz.innky.bootproj.service.ArticleService;
import xyz.innky.bootproj.service.DirectoryService;

import java.util.Arrays;

@RestController
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

}
