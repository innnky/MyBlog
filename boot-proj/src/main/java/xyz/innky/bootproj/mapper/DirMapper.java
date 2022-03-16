package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.bootproj.pojo.Dir;

import java.util.List;

@Mapper
public interface DirMapper {

    public List<String> getRecentTypes(int i);

    Integer queryDir(String dir);

    Integer addDir(Dir dir);

    Integer deleteDir(String name);
}
