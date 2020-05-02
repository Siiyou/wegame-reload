package com.game.wegame.service.sqlProvider;

import com.game.wegame.entity.User;

import java.util.List;

/**
 * @author kurobane
 * @date 2020-5-2
 * 用户账号管理Mapper提供类——供注解方式调用（保留）
 *
 * 用此种方式操作数据库跟spring自带的jdbcTemplate有何不同？？？
 */
public class UserMapperProvider {

    public String deleteByPrimaryKey(Integer id) {
        return "delete from user where id = " + id;
    }


    public String insert(User user) {
        StringBuffer sbf = new StringBuffer("");
        sbf.append("insert into user(username,password) values ('");
        sbf.append(user.getUsername());
        sbf.append("','");
        sbf.append(user.getPassword());
        sbf.append("')");
        return sbf.toString();
    }

    public String selectByPrimaryKey(Integer id) {
        return "select id,username,password from user where id="+id;
    }


    public String selectAll() {
        return "select * from user";
    }


    public String updateByPrimaryKey(User user) {
        StringBuffer sbf = new StringBuffer("");
        sbf.append("update user set username = '");
        sbf.append(user.getUsername());
        sbf.append("',password = '");
        sbf.append(user.getPassword());
        sbf.append("' where id = '");
        sbf.append(user.getId());
        sbf.append("'");
        return sbf.toString();
    }
}
