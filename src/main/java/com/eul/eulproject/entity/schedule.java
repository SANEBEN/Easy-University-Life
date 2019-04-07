package com.eul.eulproject.entity;

import com.eul.eulproject.entity.course.course;

public class schedule {
    private int id;
    private course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.eul.eulproject.entity.course.course getCourse() {
        return course;
    }

    public void setCourse(com.eul.eulproject.entity.course.course course) {
        this.course = course;
    }
}
