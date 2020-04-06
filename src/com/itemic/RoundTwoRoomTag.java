package com.itemic;

public enum RoundTwoRoomTag {
    W(0), L(1);

    private final int code;

    RoundTwoRoomTag(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
