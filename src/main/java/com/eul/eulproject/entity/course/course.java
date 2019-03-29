package com.eul.eulproject.entity.course;

import com.eul.eulproject.entity.information.message;

public class course {
    private int ID;
    private String name;
    private int Tid;
    private message teacher;
    private int begin;
    private int end;
    private String place;
    private int volume;
    private int credit;
    private int time_begin;
    private int time_end;
    private int type;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public message getTeacher() {
        return teacher;
    }

    public void setTeacher(message teacher) {
        this.teacher = teacher;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTime_begin() {
        return time_begin;
    }

    public void setTime_begin(int time_begin) {
        this.time_begin = time_begin;
    }

    public int getTime_end() {
        return time_end;
    }

    public void setTime_end(int time_end) {
        this.time_end = time_end;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
