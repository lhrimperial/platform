package com.github.platform.back.mapper;

import com.github.platform.back.domain.po.UserPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface UserMapper {

    int save(UserPO userPO);

    int update(UserPO userPO);

    UserPO findByUserName(String userName);

    UserPO findById(Integer id);

    List<UserPO> findByParams(UserPO userPO);
}
