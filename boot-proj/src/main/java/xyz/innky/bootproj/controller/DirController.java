package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.service.DirectoryService;

@RestController

public class DirController {

    @Autowired
    DirectoryService directoryService;
    @PostMapping("/dir")
    public Integer addDir(String name){
        return directoryService.addDirectory(name);
    }
    @DeleteMapping("/dir")
    public Integer deleteDir(String name){
        //ssssssssssssssssssssssssssssss
        return directoryService.deleteDir(name);
    }

}
