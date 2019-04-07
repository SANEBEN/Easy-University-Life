package com.eul.eulproject.entity.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private int id;
    private int FROM_id;
    private int TO_id;
    private Date time;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time );
    }

    public Date getTime_AsDate(){
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
