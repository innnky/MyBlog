package xyz.innky.bootproj.dto;

public class DtoArticle {
    private String title;
    private String id;

    public DtoArticle() {
    }

    public DtoArticle(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
