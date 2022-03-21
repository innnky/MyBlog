package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.bootproj.pojo.Plan;

import java.util.List;

@Mapper
public interface PlanMapper {


    List<Plan> getAllPlane();

    void updateStatus(String[] ids);
    void updateStatus2(String[] ids);
}
