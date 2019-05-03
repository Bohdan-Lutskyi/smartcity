package com.smartcity.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {

    private Long id;
    private Long taskId;
    private BigDecimal currentBudget;
    private BigDecimal transactionBudget;
    private Date createDate;
    private Date updateDate;

    public Transaction(Long id, Long taskId, BigDecimal currentBudget, BigDecimal transactionBudget, Date createDate, Date updateDate) {
        this.id = id;
        this.taskId = taskId;
        this.currentBudget = currentBudget;
        this.transactionBudget = transactionBudget;
        this.createDate = createDate;
        this.updateDate = updateDate;
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
}
