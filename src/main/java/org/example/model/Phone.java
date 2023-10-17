package org.example.model;

import org.example.enums.Operator;

public class Phone {
    private Operator operator;
    private String number;

    public Phone(Operator operator, String number) {
        this.operator = operator;
        this.number = number;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "operator=" + operator +
                ", number='" + number + '\'' +
                '}';
    }
}
