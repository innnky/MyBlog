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
    
    @RequestMapping("/directory")
    public String updateDirectory(String articleName, String articlePath, Long lastModifiedTime, String operation){
        if ("MKDIR".equals(operation)){
            directoryService.addDirectory();        
        }
        else if ("RMDIR".equals(operation)){
            directoryService.delDirectory();
        }
        return "success";
    }
    
    @RequestMapping("/article")
    public String updateArticle(){
//        if ()
        return "success";
    }
}
