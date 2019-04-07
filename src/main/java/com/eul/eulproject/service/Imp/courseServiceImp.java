package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.entity.course.coursesSimple;
import com.eul.eulproject.mapper.courseMapper;
import com.eul.eulproject.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseServiceImp implements courseService {

    private courseMapper courseMapper;

    @Autowired
    courseServiceImp(courseMapper courseMapper){
        this.courseMapper = courseMapper;
    }

    @Override
    public course getByID(String ID) {
        return courseMapper.getByID(ID);
    }

    @Override
    public coursesSimple getSimpleByID(String ID) {
        return courseMapper.getSimpleByID(ID);
    }
}

