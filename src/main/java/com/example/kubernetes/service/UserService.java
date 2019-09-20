package com.example.kubernetes.service;

import com.example.kubernetes.entity.User;

/**
 * @author liuhaozhen
 * @version Revision 1.0.0
 * @date 2019/9/20 16:21
 */
public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
