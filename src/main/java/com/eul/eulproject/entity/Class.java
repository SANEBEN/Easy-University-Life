package com.eul.eulproject.entity;

import com.eul.eulproject.entity.information.message;

import java.util.List;

public class Class {
    private List<message> messages;
    private String ID;
    private String name;
    private String type;

    public List<message> getMembers() {
        return messages;
    }

    public void setMembers(List<message> messages) {
        this.messages = messages;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
