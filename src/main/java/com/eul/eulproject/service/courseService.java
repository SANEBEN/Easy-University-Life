package com.eul.eulproject.service;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.entity.course.courseSimple;

public interface courseService {

    course getByID(String ID);

    courseSimple getSimpleByID(String ID);
}
