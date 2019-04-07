package com.eul.eulproject.entity.form;

import com.eul.eulproject.entity.course.coursesSimple;
import com.eul.eulproject.entity.friends.friendsSimple;
import com.eul.eulproject.entity.information.messageSimple;

import java.util.List;

public class simpleData {
    private messageSimple messageSimple;
    private List<coursesSimple> coursesSimpleList;
    private List<friendsSimple> friendsSimpleList;

    public com.eul.eulproject.entity.information.messageSimple getMessageSimple() {
        return messageSimple;
    }

    public void setMessageSimple(com.eul.eulproject.entity.information.messageSimple messageSimple) {
        this.messageSimple = messageSimple;
    }

    public List<coursesSimple> getCourseSimpleList() {
        return coursesSimpleList;
    }

    public void setCourseSimpleList(List<coursesSimple> courseSimpleList) {
        this.coursesSimpleList = courseSimpleList;
    }

    public List<friendsSimple> getFriendSimpleList() {
        return friendsSimpleList;
    }

    public void setFriendSimpleList(List<friendsSimple> friendSimpleList) {
        this.friendsSimpleList = friendSimpleList;
    }
}
