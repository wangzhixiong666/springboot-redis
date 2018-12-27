package com.jnshu.mapper;

import com.jnshu.domain.Teacher;



import java.util.List;
/**
 * @Mapper 这里可以使用@Mapper注解，
 * 但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
 */
public interface TeacherMapper {
//    @Select("<script>select * from teacher" +
//            "<where>" +
//            "<if test=\"name !=null \">" +
//            "name = #{name} " +
//            "</if> " +
//            "<if test=\"school !=null \">" +
//            "school = #{school} " +
//            "</if>" +
//            "</where>"+
//            "</script>")
    List<Teacher>  findTeacherByCondition(Teacher teacher);
//    @Select("select * form teacher ")
     List<Teacher> findAll();
//    @Delete("DELETE FROM teacher where id =#{id}")
     Boolean deleteById(long id);
//    @Update("Update teacher set name=#{name} where id=#{id}")
     Boolean updateTeacher(Teacher teacher);
//    @Insert("insert into teacher(name, age, school) values(#{name}, #{age}, #{school})")
    Boolean insert(Teacher teacher);

    Teacher findById(long id);
}
