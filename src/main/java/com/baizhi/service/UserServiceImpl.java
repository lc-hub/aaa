package com.baizhi.service;

import com.baizhi.dao.UserDaO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author miion
 * @create 2019-07-21 15:46
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDaO userDaO;
    @Override
    public User login(String username, String password) {
        User login = userDaO.login(username, password);

        return login;
    }
}
