package xyz.innky.bootproj.pojo;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "articleId")
    private Integer articleId;

    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "content")
    private String content;

    @Column(name = "email")
    private String email;

    @Column(name = "publishedTime")
    private java.sql.Timestamp publishedTime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Timestamp getPublishedTime() {
        return this.publishedTime;
    }

    public void setPublishedTime(java.sql.Timestamp publishedTime) {
        this.publishedTime = publishedTime;
    }
}
