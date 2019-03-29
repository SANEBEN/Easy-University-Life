package com.eul.eulproject.controller.Public;

import com.eul.eulproject.entity.course.course;
import com.eul.eulproject.service.courseService;
import com.eul.eulproject.service.scheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * 用于获取学生的课程信息
 */

@RestController
public class getCourse {

    private courseService courseService;
    private scheduleService scheduleService;

    @Autowired
    getCourse(courseService courseService,
              scheduleService scheduleService){
        this.courseService = courseService;
        this.scheduleService = scheduleService;
    }

    @PostMapping("/getCourseByID")
    public course getByID(@Param(value = "ID") String ID){
        return courseService.getByID(ID);
    }

    @PostMapping("/getCourseListByUid")
    public List<course> getByUid(@Param(value = "Uid") String Uid){
        List<String> courses = scheduleService.getCourseList(Uid);
        List<course> courseList = new LinkedList<>();
        for(String Cid : courses){
            courseList.add(courseService.getByID(Cid));
        }
        return courseList;
    }
}
