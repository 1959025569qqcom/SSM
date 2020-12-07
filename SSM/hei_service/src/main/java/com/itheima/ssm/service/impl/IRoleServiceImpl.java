package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao dao;
    @Override
    public List<Role> findAll() throws Exception{
        return dao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        dao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return dao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return dao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds){
            dao.addPermissionToRole(roleId,permissionId);
        }
    }

}
