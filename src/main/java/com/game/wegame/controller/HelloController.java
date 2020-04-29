package com.game.wegame.controller;


import com.game.wegame.entity.User;
import com.game.wegame.service.interf.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    /**
     * @author Kurobane
     * @date 2020-4-27
     * spring ioc 依赖注入
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/index")
    @ResponseBody
    public String sayHello(){
        return "bonjour je suis Kurobane";
    }

    @RequestMapping("/index2")
    public String index2(){
        return "index";
    }

/*    @RequestMapping("/index3")
    public ModelAndView index3() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }*/

    /**
     * 利用spring自带的jdbcTemplate查询数据库
     * @return
     */
    @RequestMapping("/query")
    public List<Map<String, Object>> query() {
        String sql = "select * from user";
//      执行sql语句
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    /**
     * 利用mybatis 按id查询
     * @return
     */
    @RequestMapping("/selectByPrimaryKey")
    public User selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        return user;
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/selectAll")
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }
}
