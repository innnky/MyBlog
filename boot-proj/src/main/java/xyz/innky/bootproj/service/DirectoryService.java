package xyz.innky.bootproj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.pojo.Dir;

import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {
    @Autowired
    DirMapper dirMapper;

    public List<String> getRecentTypes() {

        return dirMapper.getRecentTypes(3);
    }


    public Integer addDirectory(String name) {
        if(name.lastIndexOf("/")!=-1){
            String parentName = name.substring(0, name.lastIndexOf("/"));
            Integer parentId = dirMapper.queryDir(parentName);
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
