package com.jnshu.service.impl;

import com.jnshu.domain.Teacher;
import com.jnshu.mapper.TeacherMapper;
import com.jnshu.service.TeacherService;
import com.jnshu.until.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mr_Wang
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private  TeacherMapper teacherMapper;
    @Resource
    RedisUtil redisUtil;
    private static final Logger logger= LogManager.getLogger(TeacherServiceImpl.class);
    @Override
    public List<Teacher> findTeacherByCondition(Teacher teacher) {
        return teacherMapper.findTeacherByCondition(teacher);
    }

    @Override
    public List <Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Boolean deleteById(long id) {
       if(teacherMapper.deleteById(id)){
           logger.info("同时删除缓存数据");
           redisUtil.del("teacher"+id);
           return true;
       }
       return false;
    }

    @Override
    public Boolean updateTeacher(Teacher teacher) {
        if(teacherMapper.updateTeacher(teacher)){
            logger.info("更新缓存数据");
            redisUtil.set("teacher"+teacher.getId(),teacher);
            return true;
        }
        return false;
    }

    @Override
    public Boolean insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public Teacher selectById(long id) {
        logger.info("从缓存中获取数据");
        Teacher teacher= (Teacher) redisUtil.get("teacher"+id);
        if(teacher==null){
            logger.info("从数据库中取");
           teacher=teacherMapper.findById(id);
           logger.info("同时添加数据到缓存中");
           redisUtil.set("teacher"+id,teacher);
        }
        return teacher;
    }
}