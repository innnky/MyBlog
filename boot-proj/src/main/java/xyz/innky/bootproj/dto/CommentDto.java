package xyz.innky.bootproj.dto;


import java.util.ArrayList;
import java.util.List;

public class CommentDto {
    private Integer id;
    private List<CommentDto> children = new ArrayList<>();
    private Integer articleId;
    private String content;
    private String  publishedTime;
    private String email;

    public void addChild(CommentDto commentDto){
        children.add(commentDto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CommentDto> getChildren() {
        return children;
    }

    public void setChildren(List<CommentDto> children) {
        this.children = children;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
