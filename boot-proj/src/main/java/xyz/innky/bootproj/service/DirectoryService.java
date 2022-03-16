package xyz.innky.bootproj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.mapper.DirMapper;

import java.util.List;

@Service
public class DirectoryService {
    @Autowired
    DirMapper dirMapper;

    public List<String> getRecentTypes() {

        return dirMapper.getRecentTypes(3);
    }

    public boolean addDirectory(){
        return false;
    }
    public boolean delDirectory(){
        return false;
    }
}
