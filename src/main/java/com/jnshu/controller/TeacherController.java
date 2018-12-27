package com.jnshu.controller;

import com.jnshu.domain.Teacher;
import com.jnshu.service.impl.TeacherServiceImpl;
import com.jnshu.tool.CodeMsg;
import com.jnshu.tool.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Mr_Wang
 */
@RestController
public class TeacherController {
    @Resource
    TeacherServiceImpl teacherService;
    private static final Logger logger= LogManager.getLogger(TeacherController.class);
    /**
     * 增加学生数据
     * @param teacher
     * @return Result
     */
    @RequestMapping(value = "/teacher",method = RequestMethod.POST)
    public Result add(@RequestBody Teacher teacher){
        logger.info("参数teacher"+teacher);
        boolean flag=teacherService.insert(teacher);
        if(flag){
            return Result.success(CodeMsg.SUCCESS);
        }
          return   Result.error(CodeMsg.SERVER_ERROR);
    }


    /**
     * 按照id删除学生数据
     * @param  id
     * @return Result
     */
    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable ("id")long id){
        logger.info("参数id"+id);
        if(teacherService.deleteById(id)){
            return  Result.success(CodeMsg.SUCCESS);
        }
        return   Result.error(CodeMsg.SERVER_ERROR);
    }


    @RequestMapping(value ="/teacher",method =RequestMethod.PUT)
    public  Result update(@RequestBody Teacher teacher){
        if(teacherService.updateTeacher(teacher)){
            return  Result.success(CodeMsg.SUCCESS);
        }
        return   Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public Result select(@RequestBody Teacher teacher){
        List<Teacher> teacherList=teacherService.findTeacherByCondition(teacher);
        if(teacherList!=null){
            return Result.success(teacherList);
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping(value = "/teachers",method = RequestMethod.GET)
    public Result select(){
        List<Teacher> teacherList=teacherService.findAll();
        if(teacherList!=null){
            return Result.success(teacherList);
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
    public Result select(@PathVariable("id")long id){
        Teacher teacher=teacherService.selectById(id);
        if(teacher!=null){
            return Result.success(teacher);
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }
}