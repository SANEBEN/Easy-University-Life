package com.eul.eulproject.service;

import com.eul.eulproject.entity.friends.friendsSimple;
import com.eul.eulproject.entity.friends.friend;

import java.util.List;

public interface friendService {

    List<friend> getByUid_simple(String Uid);

    List<friend> getByUid_complete(String Uid);

    List<friendsSimple> getSimpleFriends(String Uid);
}
