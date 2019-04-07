package com.eul.eulproject.service.Imp;

import com.eul.eulproject.mapper.subscribeMapper;
import com.eul.eulproject.service.subscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subscribeServiceImp implements subscribeService{

    private subscribeMapper subscribeMapper;

    @Autowired
    subscribeServiceImp(subscribeMapper subscribeMapper){
        this.subscribeMapper = subscribeMapper;
    }

    @Override
    public boolean add(int author, int customer) {
        return subscribeMapper.add(author,customer);
    }

    @Override
    public List<String> get(int author) {
        return subscribeMapper.get(author);
    }
}
