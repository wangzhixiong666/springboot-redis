package com.jnshu.service;

import com.jnshu.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherService {
    List<Teacher> findTeacherByCondition(Teacher teacher);
    List<Teacher> findAll();
    Boolean deleteById(long id);
    Boolean updateTeacher(Teacher teacher);
    Boolean insert(Teacher teacher);
    Teacher selectById(long id);
}