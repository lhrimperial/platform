package com.github.platform.back.service;

import com.github.platform.back.domain.po.UserPO;

import java.util.List;

/**
 *
 */
public interface IUserService {

    int save(UserPO userPO);

    int update(UserPO userPO);

    int deleteByUserName(String userName);

    int deleteById(Integer id);

    UserPO findByUserName(String userName);

    UserPO findById(Integer id);

    List<UserPO> findByParams(UserPO userPO, int pageNo, int pageSize);
}
