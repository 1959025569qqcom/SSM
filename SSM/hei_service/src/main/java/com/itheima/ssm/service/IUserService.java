package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAllUser() throws Exception;

    //用户添加
    void save(UserInfo userInfo) throws Exception;
    //用户详情查询
    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userid)throws Exception;

    void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
