package com.eul.eulproject.controller.chat.netty.message;

public class General {
    private int type;
    private Object message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
