package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private IRoleService service;

    //给角色添加权限的方法
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] permissionIds)throws Exception{
        service.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll";
        }
    //查询角色以及角色可以添加的权限
    @RequestMapping("findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)String roleId)throws Exception{
        ModelAndView mv = new ModelAndView();
        //1、根据角色id查询角色
        Role role = service.findById(roleId);
        //2、根据角色id查询角色可以添加的权限
        List<Permission> OtherPermissions = service.findOtherPermissions(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",OtherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> list = service.findAll();
        mv.addObject("roleList", list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save")
    public String save(Role role) throws Exception {
        service.save(role);
        return "redirect:findAll";
    }
}
