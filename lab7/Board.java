package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Token> tokenList = new ArrayList<>();

    Board(int numberOfTokens) {
        for (int i = 0; i < numberOfTokens; i++) {
            Token token = new Token();
            token.setValue(i);
            this.tokenList.add(token);
        }
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public void deleteToken(Token t) {
        tokenList.remove(t);
    }

    public List<Token> getTokenList() {
        return tokenList;
    }
}
