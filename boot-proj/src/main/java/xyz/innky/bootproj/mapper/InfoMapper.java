package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.bootproj.pojo.Info;

import java.util.List;

@Mapper
public interface InfoMapper {

    List<Info> getInfos();
}
