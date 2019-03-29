package com.eul.eulproject.entity.friends;

import com.eul.eulproject.entity.information.message;

public class friend {
    private int ID;
    private message friend;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public message getFriend() {
        return friend;
    }

    public void setFriend(message friends) {
        this.friend = friends;
    }
}
