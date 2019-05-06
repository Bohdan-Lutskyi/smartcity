package com.smartcity.domain;

import java.lang.Long;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDate deadlineDate;
    private String taskStatus;
    private Long budget;
    private Long approvedBudget;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private Long userOrganizationId;
    private List<Transaction> transactionList;

    public Task() {
    }

    public Task(Long id, String title, String description, LocalDate deadlineDate, String taskStatus,
                Long budget, Long approvedBudget, LocalDate createdDate, LocalDate updatedDate,
                Long userOrganizationId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.taskStatus = taskStatus;
        this.budget = budget;
        this.approvedBudget = approvedBudget;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getApprovedBudget() {
        return approvedBudget;
    }

    public void setApprovedBudget(Long approvedBudget) {
        this.approvedBudget = approvedBudget;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(Long userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return title.equals(task.title) &&
                description.equals(task.description) &&
                Objects.equals(deadlineDate, task.deadlineDate) &&
                taskStatus.equals(task.taskStatus) &&
                Objects.equals(budget, task.budget) &&
                Objects.equals(approvedBudget, task.approvedBudget) &&
                userOrganizationId.equals(task.userOrganizationId) &&
                Objects.equals(transactionList, task.transactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadlineDate, taskStatus,
                budget, approvedBudget, createdDate, updatedDate,
                userOrganizationId, transactionList);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadlineDate=" + deadlineDate +
                ", taskStatus=" + taskStatus +
                ", budget=" + budget +
                ", approvedBudget=" + approvedBudget +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", userOrganizationId=" + userOrganizationId +
                ", transactionList=" + transactionList +
                '}';
    }
}
