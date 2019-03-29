package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.schedule;
import com.eul.eulproject.mapper.ScheduleMapper;
import com.eul.eulproject.service.scheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImp implements scheduleService {

    private ScheduleMapper scheduleMapper;

    @Autowired
    ScheduleServiceImp(ScheduleMapper scheduleMapper){
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public List<String> getCourseList(String Uid) {
        return scheduleMapper.getCourseList(Uid);
    }

    @Override
    public List<schedule> getByStudent(String student) {
        return scheduleMapper.getByStudent(student);
    }
}

