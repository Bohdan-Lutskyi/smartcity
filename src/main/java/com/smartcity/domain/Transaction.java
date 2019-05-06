package com.smartcity.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {

    private Long id;
    private Long taskId;
    private BigDecimal currentBudget;
    private BigDecimal transactionBudget;
    private Date createdDate;
    private Date updatedDate;

    public Transaction() {
    }

    public Transaction(Long id, Long taskId, BigDecimal currentBudget, BigDecimal transactionBudget, Date createdDate, Date updatedDate) {
        this.id = id;
        this.taskId = taskId;
        this.currentBudget = currentBudget;
        this.transactionBudget = transactionBudget;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public BigDecimal getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(BigDecimal currentBudget) {
        this.currentBudget = currentBudget;
    }

    public BigDecimal getTransactionBudget() {
        return transactionBudget;
    }

    public void setTransactionBudget(BigDecimal transactionBudget) {
        this.transactionBudget = transactionBudget;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
