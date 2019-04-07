package com.eul.eulproject.entity.information;

public class messageSimple {
    private int id;
    private String IDNumber;
    private String realName;
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
