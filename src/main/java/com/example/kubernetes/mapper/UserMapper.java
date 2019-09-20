package com.example.kubernetes.mapper;

import com.example.kubernetes.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuhaozhen
 * @version Revision 1.0.0
 * @date 2019/9/20 16:21
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}