package xyz.innky.bootproj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.bootproj.vo.Article;
import xyz.innky.bootproj.vo.IndexInformationVO;
import xyz.innky.bootproj.vo.Inf;

import java.util.Arrays;

@RestController
public class ArticleController {
    @GetMapping("/indexInformation")
    public IndexInformationVO getIndexInformation(){
        IndexInformationVO indexInformationVO = new IndexInformationVO();
        indexInformationVO.setPersonalInf(Arrays.asList(
                new Inf("Bilibili","Bilibili","Bilibili","https://img1.baidu.com/it/u=2703487632,963885301&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"),
                new Inf("Bilibili","Bilibili","Bilibili","https://img1.baidu.com/it/u=2703487632,963885301&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"),
                new Inf("Bilibili","Bilibili","Bilibili","https://img1.baidu.com/it/u=2703487632,963885301&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500")
        ));
        indexInformationVO.setRecentArticles(Arrays.asList(
                new Article("SpringBoot笔记",""),
                new Article("SpringBoot笔记","")
        ));
        indexInformationVO.setTypes(Arrays.asList("前端", "后端"));
        return indexInformationVO;
    }
}
