package com.eul.eulproject.service;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.entity.course.coursesSimple;

public interface courseService {

    course getByID(String ID);

    coursesSimple getSimpleByID(String ID);
}
