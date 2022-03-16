package xyz.innky.bootproj.pojo;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "path")
    private String path;

    @Column(name = "dirId")
    private Integer dirId;

    @Column(name = "lastModificationTime")
    private Long lastModificationTime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDirId() {
        return this.dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public Long getLastModificationTime() {
        return this.lastModificationTime;
    }

    public void setLastModificationTime(Long lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", path='" + path + '\'' +
                ", dirId=" + dirId +
                ", lastModificationTime=" + lastModificationTime +
                '}';
    }
}
