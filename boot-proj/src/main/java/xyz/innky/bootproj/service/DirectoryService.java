package xyz.innky.bootproj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.pojo.Dir;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {
    @Autowired
    DirMapper dirMapper;

    public List<String> getRecentTypes() {

        List<String> result = new ArrayList<>();
        for (String recentType : dirMapper.getRecentTypes(3)) {
            String x = recentType.substring(0, recentType.length()-1);
            x = x.substring(x.lastIndexOf('/')+1);
            result.add(x);
        }
        return result;
    }


    public Integer addDirectory(String name) {
        if(name.lastIndexOf("/")!=-1){

            String parentName = name.substring(0, name.lastIndexOf("/"));
            parentName +="/";
            Integer parentId = dirMapper.queryDir(parentName);
            name+="/";
            if(parentId != null){
                Dir dir = new Dir();
                dir.setCreateTime(System.currentTimeMillis());
                dir.setName(name);
                dir.setParentId(parentId);
                return dirMapper.addDir(dir);
            }
            return 0;
        }
        else {
            Dir dir = new Dir();
            dir.setCreateTime(System.currentTimeMillis());
            dir.setName(name);
            return dirMapper.addDir(dir);
        }
    }

    public Integer deleteDir(String name) {
        return dirMapper.deleteDir(name);
    }
}
