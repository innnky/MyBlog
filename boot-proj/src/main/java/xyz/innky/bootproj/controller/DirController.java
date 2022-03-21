package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.innky.bootproj.dto.DirDto;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.service.DirectoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin()

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

    @GetMapping("/dir/all")
    public Object getAllDir(){
        List<DirDto> dirDtos = directoryService.getAllDirs();
        Map<String, Object> map = new HashMap<>();
        map.put("dirs", dirDtos);
        return map;

    }
}
