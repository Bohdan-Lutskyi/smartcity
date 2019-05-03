package com.smartcity.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Task {

    private Long id;
    private String title;
    private Date createDate;
    private Date updateDate;
    private String description;
    private Date deadlineDate;
    private BigDecimal budget;
    private BigDecimal approvedBudget;
    private Long taskStatusId;
    private Long userOrganizationId;

    public Task() {
    }

    public Task(Long id, String title, Date createDate, Date updateDate, String description, Date deadlineDate,
                BigDecimal budget, BigDecimal approvedBudget, Long taskStatusId, Long userOrganizationId) {
        this.id = id;
        this.title = title;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.budget = budget;
        this.approvedBudget = approvedBudget;
        this.taskStatusId = taskStatusId;
        this.userOrganizationId = userOrganizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getApprovedBudget() {
        return approvedBudget;
    }

    public void setApprovedBudget(BigDecimal approvedBudget) {
        this.approvedBudget = approvedBudget;
    }

    public Long getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(Long taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public Long getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(Long userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }
}
