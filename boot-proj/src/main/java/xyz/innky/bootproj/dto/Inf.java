package xyz.innky.bootproj.dto;

public class Inf {
    private String title;
    private String id;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Inf(String title, String id, String description, String link, String img) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.link = link;
        this.img = img;
    }

    public Inf() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String link;
    private String img;

}
