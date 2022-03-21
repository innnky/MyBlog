package xyz.innky.bootproj.dto;

import xyz.innky.bootproj.pojo.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlanDto {
    private String id;
    private List<PlanDto> children = new ArrayList<>();
    private Byte completed;
    private Integer content;
    private Integer estimatedTime;
    private String  startTime;
    private String  completionTime;

    public void addChild(PlanDto planDto){
        this.children.add(planDto);
    }

    public Byte getCompleted() {
        return completed;
    }

    public void setCompleted(Byte completed) {
        this.completed = completed;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public List<PlanDto> getChildren() {
        return children;
    }

    public void setChildren(List<PlanDto> children) {
        this.children = children;
    }
}
