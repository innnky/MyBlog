package xyz.innky.bootproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.dto.PlanDto;
import xyz.innky.bootproj.mapper.PlanMapper;
import xyz.innky.bootproj.pojo.Plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlanService {
    @Autowired
    PlanMapper planMapper;

    public List<PlanDto> getAllPlans() {
        List<Plan> plans = planMapper.getAllPlane();
        Map<Integer, PlanDto> map = new HashMap<>();
        List<PlanDto> result = new ArrayList<>();
        for (Plan plan : plans) {
            PlanDto planDto = new PlanDto();
            planDto.setId(plan.getId().toString());
            planDto.setCompleted(plan.getCompleted());
            planDto.setContent(plan.getContent());
            planDto.setEstimatedTime(plan.getEstimatedTime());
            planDto.setStartTime(plan.getStartTime().toString());
            planDto.setCompletionTime(plan.getCompletionTime().toString());
            map.put(plan.getId(), planDto);
            if (plan.getParentId() != null){
                map.get(plan.getParentId()).addChild(planDto);
            }else {
                result.add(planDto);
            }
        }
        return result;
    }

    public void updateStatus(String ids) {
        String[] split = ids.split(",");
        planMapper.updateStatus(split);
        planMapper.updateStatus2(split);
    }
}
