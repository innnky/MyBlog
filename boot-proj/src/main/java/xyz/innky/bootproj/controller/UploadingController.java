package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.bootproj.service.DirectoryService;

@RestController
@RequestMapping("/uploading")
public class UploadingController {

    @Autowired
    DirectoryService directoryService;
    

    @RequestMapping("/article")
    public String updateArticle(){
//        if ()
        return "success";
    }
}
