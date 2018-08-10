package com.github.platform.back.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.platform.back.domain.po.UserPO;
import com.github.platform.back.mapper.UserMapper;
import com.github.platform.back.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int save(UserPO userPO) {
        if (userPO == null) {
            throw new IllegalArgumentException("save user undo, userPO is empty");
        }
        Date date = new Date();
        userPO.setCreateTime(date);
        userPO.setModifyTime(date);
        return userMapper.save(userPO);
    }

    @Override
    public int update(UserPO userPO) {
        if (userPO == null) {
            throw new IllegalArgumentException("update user undo, userPO is empty");
        }
        Date date = new Date();
        userPO.setModifyTime(date);
        return userMapper.update(userPO);
    }

    @Override
    public int deleteByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            throw new IllegalArgumentException("deleteByUserName undo, userName is empty");
        }
        UserPO userPO = new UserPO();
        userPO.setUserName(userName);
        userPO.setActive("Y");
        userPO.setModifyTime(new Date());
        return userMapper.update(userPO);
    }

    @Override
    public int deleteById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("deleteById undo, id is empty");
        }
        UserPO userPO = new UserPO();
        userPO.setId(id);
        userPO.setActive("Y");
        userPO.setModifyTime(new Date());
        return userMapper.update(userPO);
    }

    @Override
    public UserPO findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public UserPO findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<UserPO> findByParams(UserPO userPO, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.findByParams(userPO);
    }
}
