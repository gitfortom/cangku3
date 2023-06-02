package com.example.redis_sb.controller;

import com.example.redis_sb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://blog.csdn.net/qq_43230007/article/details/108306010  redisTemplate常用APIK
 * https://www.jianshu.com/p/5596c3a4978d
 */
@Controller
public class TestController {
    @Autowired
    private RedisTemplate  redisTemplate;
    /**
     * 操作String的对象
     */
    @Autowired

    private ValueOperations valueOperations;
    @Autowired
    private HashOperations hashOperations;
    @Autowired
    private ListOperations listOperations;
    @Autowired
    private SetOperations setOperations;
    @Autowired
    private ZSetOperations zSetOperations;
    /*
    存String
     */
    @RequestMapping("/getAndSet")
    @ResponseBody
    public String getAndSet(String name,String value){
        //必须要去redisTemplate.opsForxxxxx，获取操作对象

        valueOperations.set(name,value);

        return (String) valueOperations.get(name);
    }
    /*
    存对象
     */
    @RequestMapping("/getSet")
    @ResponseBody
    public List getAndSet(@RequestBody Person person){
        System.out.println(person);
        Person person1 = new Person();
        person1.setId(3);
        person1.setName("王麻子");
        person1.setAge("55");
        person1.setAddress("重庆");
        //获取list操作对象
        listOperations.leftPushAll("persons",person,person1);

        return  listOperations.range("persons",0,-1);
    }
    /*
    存取散列
     */
    @RequestMapping("/getSetHash")
    @ResponseBody
   public String hmSet(String key,String hashKey,String value){
       //存值
       hashOperations.put(key,hashKey,value);
       //取值
       String o =(String) hashOperations.get(key, hashKey);
       System.out.println(o);
       return o;
   }

   /*
   操作Set集合
    */

    @RequestMapping("/getSetOperations")
    @ResponseBody
    public Set<Object> SetOperations(){
        //添加
        setOperations.add("weather","cloud","rainy");
        //查询
        Set weather = setOperations.members("weather");
        return weather;
    }

     /*
   操作ZSet集合
    */
    @RequestMapping("/getZsetOperations")
    @ResponseBody
    public Set<Object> getZsetOperations(){

        zSetOperations.add("achievement","A",90);
        zSetOperations.add("achievement","B",80);
        zSetOperations.add("achievement","C",70);
        zSetOperations.add("achievement","D",70);
        //取值
        // Set achievement = zSetOperations.range("achievement", 0, -1);
        Set achievement = zSetOperations.rangeByScore("achievement", 80, 90);
        return achievement;
    }
}
