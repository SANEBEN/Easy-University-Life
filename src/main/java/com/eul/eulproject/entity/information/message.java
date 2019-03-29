package com.eul.eulproject.entity.information;

import com.eul.eulproject.entity.major;
import com.eul.eulproject.entity.school;

import java.util.Date;

public class message {
    private int ID;
    private String IDNumber;
    private String realName;
    private String Sid;
    private com.eul.eulproject.entity.school school;
    private String Mid;
    private com.eul.eulproject.entity.major major;
    private int gender;
    private String email;
    private Date createdTime;
    private int role;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public com.eul.eulproject.entity.school getSchool() {
        return school;
    }

    public void setSchool(com.eul.eulproject.entity.school school) {
        this.school = school;
    }

    public String getMid() {
        return Mid;
    }

    public void setMid(String mid) {
        Mid = mid;
    }

    public com.eul.eulproject.entity.major getMajor() {
        return major;
    }

    public void setMajor(com.eul.eulproject.entity.major major) {
        this.major = major;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
