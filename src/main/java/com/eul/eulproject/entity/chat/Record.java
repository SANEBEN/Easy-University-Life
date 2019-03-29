package com.eul.eulproject.entity.chat;

import java.util.Date;

public class Record {
    private int ID;
    private int FROM_id;
    private int TO_id;
    private Date time;
    private String content;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFROM_id() {
        return FROM_id;
    }

    public void setFROM_id(int FROM_id) {
        this.FROM_id = FROM_id;
    }

    public int getTO_id() {
        return TO_id;
    }

    public void setTO_id(int TO_id) {
        this.TO_id = TO_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
