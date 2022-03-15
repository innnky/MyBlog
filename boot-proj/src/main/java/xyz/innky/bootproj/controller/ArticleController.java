package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.bootproj.dto.IndexInformationVO;
import xyz.innky.bootproj.dto.Inf;
import xyz.innky.bootproj.service.ArticleService;

import java.util.Arrays;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;


    @GetMapping("/indexInformation")
    public IndexInformationVO getIndexInformation(){
        IndexInformationVO indexInformationVO = new IndexInformationVO();
        indexInformationVO.setPersonalInf(articleService.getInfos());
        indexInformationVO.setRecentArticles(articleService.getRecentArticles());
        indexInformationVO.setTypes(articleService.getRecentTypes());
        return indexInformationVO;
    }
}
