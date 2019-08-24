package com.baizhi.service;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author miion
 * @create 2019-07-21 15:45
 */
public interface UserService {
    User login(@Param("username") String username, @Param("password") String password);

}
