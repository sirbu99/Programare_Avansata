package com.company;

public class Token {
    private int value;

    public Token() {
        this.value = '\0';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
