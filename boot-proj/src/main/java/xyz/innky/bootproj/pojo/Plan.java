package xyz.innky.bootproj.pojo;


public class Plan {
    private Integer id;

    private Byte completed;

    private Integer parentId;

    private Integer content;

    private Integer estimatedTime;

    private java.sql.Date startTime;

    private java.sql.Date completionTime;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getCompleted() {
        return this.completed;
    }

    public void setCompleted(Byte completed) {
        this.completed = completed;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getContent() {
        return this.content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getEstimatedTime() {
        return this.estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public java.sql.Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.sql.Date startTime) {
        this.startTime = startTime;
    }

    public java.sql.Date getCompletionTime() {
        return this.completionTime;
    }

    public void setCompletionTime(java.sql.Date completionTime) {
        this.completionTime = completionTime;
    }
}
