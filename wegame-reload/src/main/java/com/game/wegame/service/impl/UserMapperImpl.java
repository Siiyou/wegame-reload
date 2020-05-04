package com.game.wegame.service.impl;

import com.game.wegame.entity.User;
import com.game.wegame.service.interf.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kurobane
 * @date 2020-5-2
 * 用户账号管理业务类
 */

@Service
public class UserMapperImpl{

    @Autowired
    UserMapper userMapper;

    /**
     * 根据id删除user数据记录
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增user
     * @param user
     * @return
     */
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 更新user
     * @param user
     * @return
     */
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * 根据id搜索user
     * @param id
     * @return
     */
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List selectAll() {
        return userMapper.selectAll();
    }

    @Transactional
    public int checkPassword(User user) {
        String password = user.getPassword();
        String username = user.getUsername();

        if (password.equals("")||username.equals(""))
            return -1;

        return userMapper.checkPassword(user);

    }

}
