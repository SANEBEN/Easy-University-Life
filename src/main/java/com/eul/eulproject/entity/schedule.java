package com.eul.eulproject.entity;

import com.eul.eulproject.entity.course.course;

public class schedule {
    private int ID;
    private course course;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public com.eul.eulproject.entity.course.course getCourse() {
        return course;
    }

    public void setCourse(com.eul.eulproject.entity.course.course course) {
        this.course = course;
    }
}
