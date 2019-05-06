package com.smartcity.domain;


import java.math.BigDecimal;

public class Budget {

    private BigDecimal value;

    public Budget() {
    }

    public Budget(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
