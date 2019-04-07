package com.eul.eulproject.entity.friends;

import com.eul.eulproject.entity.information.message;

public class friend {
    private int id;
    private message friend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public message getFriend() {
        return friend;
    }

    public void setFriend(message friends) {
        this.friend = friends;
    }
}
