package xyz.innky.bootproj.dto;

import java.util.ArrayList;
import java.util.List;

public class DirDto {
    private String id;
    private String label;
    private List<DirDto> children = new ArrayList<>();

    public void addChildren(DirDto dto){
        children.add(dto);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<DirDto> getChildren() {
        return children;
    }

    public void setChildren(List<DirDto> children) {
        this.children = children;
    }
}
