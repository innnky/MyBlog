package xyz.innky.bootproj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.innky.bootproj.dto.PlanDto;
import xyz.innky.bootproj.service.PlanService;

import java.util.List;



@RestController
@CrossOrigin
public class PlanController {

    @Autowired
    PlanService planService;

    @GetMapping("/plan/all")
    public List<PlanDto> getAllPlans(){

        return planService.getAllPlans();
    }

    @PutMapping("/plan/complete/{ids}")
    public Object updateStatus(@PathVariable("ids") String ids){
        planService.updateStatus(ids);
        return null;
    }
}
