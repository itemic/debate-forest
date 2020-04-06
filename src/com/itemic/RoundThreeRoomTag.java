package com.itemic;

public enum RoundThreeRoomTag {
    WW(0), WL(1), LW(2), LL(3);

    private final int code;

    RoundThreeRoomTag(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
