package com.eul.eulproject.entity.course;

public class coursesSimple {
    private int id;
    private String name;
    private int Tid;
    private String teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
