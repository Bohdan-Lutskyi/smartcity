package com.smartcity.domain;

import java.sql.Date;

public class Comment {

    private Long id;
    private String description;
    private Date createDate;
    private Date updateDate;
    private Long userId;
    private Long TaskId;

    public Comment(Long id, String description, Date createDate, Date updateDate, Long userId, Long taskId) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
        TaskId = taskId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return TaskId;
    }

    public void setTaskId(Long taskId) {
        TaskId = taskId;
    }
}
