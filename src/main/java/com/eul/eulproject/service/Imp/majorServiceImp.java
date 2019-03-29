package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.major;
import com.eul.eulproject.mapper.majorMapper;
import com.eul.eulproject.service.majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class majorServiceImp implements majorService {

    private majorMapper majorMapper;

    @Autowired
    majorServiceImp(majorMapper majorMapper){
        this.majorMapper = majorMapper;
    }

    @Override
    public major getByID(String ID) {
        return majorMapper.getByID(ID);
    }
}
