package com.jnshu;

import com.jnshu.domain.Teacher;
import com.jnshu.until.MemcacheUtil;
import net.spy.memcached.MemcachedClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {
    @Autowired
    MemcacheUtil memcacheUtil;
    private MemcachedClient memcachedClient;
    @Before
    public void before() {
         memcachedClient=memcacheUtil.getClient();
    }
    @Test
    public void test1() {
        Teacher teacher=new Teacher();
        teacher.setName("srtdr");
        teacher.setAge(11);
        teacher.setSchool("武汉大学");
        memcachedClient.set("teacher",60000,teacher);
    }

    @Test
    public void test2() {
        Teacher teacher= (Teacher) memcachedClient.get("teacher");
        System.out.println(teacher);
    }
}

