package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;


import java.util.List;

public interface IRoleService {

    public List<Role> findAll()throws Exception;

    //角色添加
    void save(Role role) throws Exception;

    Role findById(String roleId)throws Exception;

    List<Permission> findOtherPermissions(String roleId)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds)throws Exception;
}
