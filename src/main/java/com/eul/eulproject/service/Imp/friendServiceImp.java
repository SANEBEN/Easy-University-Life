package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.friends.friendsSimple;
import com.eul.eulproject.entity.friends.friend;
import com.eul.eulproject.mapper.friendsMapper;
import com.eul.eulproject.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class friendServiceImp implements friendService {

    private friendsMapper friendsMapper;

    @Autowired
    friendServiceImp(friendsMapper friendsMapper) {
        this.friendsMapper = friendsMapper;
    }

    @Override
    public List<friend> getByUid_simple(String Uid) {
        return friendsMapper.getByUid_simple(Uid);
    }

    @Override
    public List<friend> getByUid_complete(String Uid) {
        return friendsMapper.getByUid_complete(Uid);
    }

    @Override
    public List<friendsSimple> getSimpleFriends(String Uid) {
        return friendsMapper.getSimpleFriends(Uid);
    }
}
