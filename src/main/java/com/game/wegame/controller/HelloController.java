package com.game.wegame.controller;


import com.game.wegame.entity.User;
import com.game.wegame.service.interf.UserMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8888"})
@Controller
public class HelloController {

    /**
     * @author Kurobane Lia
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
        return "manage";
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
    @ResponseBody
    public User selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        return user;
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> selectAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    @Transactional  //该注解用于事务的控制
    public int insert(HttpServletRequest request, HttpServletResponse response) {
        String formData = request.getParameter("formData");
        JSONObject formObject = JSONObject.fromObject(formData);
        User user = new User();
        user.setUsername((String)formObject.get("username"));
        user.setPassword((String)formObject.get("password"));
        int i = userMapper.insert(user);
        int j=1/0;//用算术异常终止程序，由于开启了事务，已经执行insert操作的数据会回滚
        System.out.println(1);
        return i;
    }
}
