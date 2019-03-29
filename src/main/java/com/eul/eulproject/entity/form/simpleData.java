package com.eul.eulproject.entity.form;

import com.eul.eulproject.entity.course.courseSimple;
import com.eul.eulproject.entity.friends.friendSimple;
import com.eul.eulproject.entity.information.messageSimple;

import java.util.List;

public class simpleData {
    private messageSimple messageSimple;
    private List<courseSimple> courseSimpleList;
    private List<friendSimple> friendSimpleList;

    public com.eul.eulproject.entity.information.messageSimple getMessageSimple() {
        return messageSimple;
    }

    public void setMessageSimple(com.eul.eulproject.entity.information.messageSimple messageSimple) {
        this.messageSimple = messageSimple;
    }

    public List<courseSimple> getCourseSimpleList() {
        return courseSimpleList;
    }

    public void setCourseSimpleList(List<courseSimple> courseSimpleList) {
        this.courseSimpleList = courseSimpleList;
    }

    public List<friendSimple> getFriendSimpleList() {
        return friendSimpleList;
    }

    public void setFriendSimpleList(List<friendSimple> friendSimpleList) {
        this.friendSimpleList = friendSimpleList;
    }
}
