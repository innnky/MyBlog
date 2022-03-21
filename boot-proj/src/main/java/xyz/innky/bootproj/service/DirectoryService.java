package xyz.innky.bootproj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.innky.bootproj.dto.DirDto;
import xyz.innky.bootproj.mapper.DirMapper;
import xyz.innky.bootproj.pojo.Dir;

import java.lang.reflect.Field;
import java.util.*;

@Service
@Transactional
public class DirectoryService {
    @Autowired
    DirMapper dirMapper;
    @Autowired
    ArticleService articleService;

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

    public List<DirDto> getAllDirs() {
        List<Dir> dirs = dirMapper.getAllDirs();

        Map<Integer, DirDto> map = new HashMap<>();
        for (Dir dir : dirs) {
            DirDto dto = new DirDto();
            dto.setId(dir.getId().toString());
            dto.setLabel(processName(dir.getName()));
            map.put(dir.getId(),dto);
            if (dir.getParentId() != null){
                map.get(dir.getParentId()).addChildren(dto);
            }
        }
//        articleService.getAllArticle(0,-1);
        return map.get(10).getChildren();
    }

    public String processName(String fullName){
        if ("/".equals(fullName))
            return fullName;
        String substring = fullName.substring(0, fullName.length() - 1);
        return substring.substring(substring.lastIndexOf("/")+1);
    }
}
