package xyz.innky.bootproj.vo;

public class Inf {
    private String title;
    private String id;


    public Inf() {
    }

    public Inf(String title, String id, String link, String img) {
        this.title = title;
        this.id = id;
        this.link = link;
        this.img = img;
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
