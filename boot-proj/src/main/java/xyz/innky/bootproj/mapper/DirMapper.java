package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DirMapper {

    public List<String> getRecentTypes(int i);
}
