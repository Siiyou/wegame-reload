package com.game.wegame.service.interf;

import com.game.wegame.entity.User;
import com.game.wegame.service.sqlProvider.UserMapperProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kurobane
 * @date 2020-5-2
 * 用户账号管理数据类 mapper类
 */
@Mapper
@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKey(Integer id);

    int checkPassword(User record);

    List selectAll();


}