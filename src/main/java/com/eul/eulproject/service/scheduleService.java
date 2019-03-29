package com.eul.eulproject.service;

import com.eul.eulproject.entity.schedule;

import java.util.List;

public interface scheduleService {

    List<schedule> getByStudent(String Uid);

    List<String> getCourseList(String Uid);
}
