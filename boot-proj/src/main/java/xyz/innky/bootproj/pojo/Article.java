package xyz.innky.bootproj.pojo;


public class Article {
    private Integer id;

    private String title;

    private String content;

    private String path;

    private Integer dirId;

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
