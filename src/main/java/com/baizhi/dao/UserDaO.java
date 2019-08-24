package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author miion
 * @create 2019-07-17 21:07
 */
public interface UserDaO {
    User login(@Param("username") String username, @Param("password") String password);
}
