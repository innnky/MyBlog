package xyz.innky.utils;

import cn.hutool.http.HttpUtil;
import xyz.innky.Config;

import java.io.File;
import java.util.HashMap;

public class HttpArticleUploader {
    public void del(File file){
        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length());
        String title = substring.substring(substring.lastIndexOf('/')+1, substring.lastIndexOf("."));
        String path = substring.substring(0, substring.lastIndexOf("/")+1);
        System.out.println(path);
    }
    public void upload(File file){
        if(file.getName().startsWith(".")|| !file.getName().endsWith(".md")){
            return;
        }
        System.out.println(file.getAbsolutePath());

        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length());
        String title = substring.substring(substring.lastIndexOf('/')+1, substring.lastIndexOf("."));
        String path = substring.substring(0, substring.lastIndexOf("/")+1);
        String content = MdFileReaderUtil.readFile(file);
        String lastModifiedTime = String.valueOf(file.lastModified());

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("title", title);
        paramMap.put("dir", path);
        paramMap.put("content", content);
        paramMap.put("lastModifiedTime", lastModifiedTime);
//
        HttpUtil.post("http://localhost:8081/article", paramMap);
    }
    public void mkdir(File file){

        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(Config.targetDirectory.length());
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", substring);

        HttpUtil.post("http://localhost:8081/dir", paramMap);
    }
}
