package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    //给用户添加角色
    @RequestMapping("addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        service.addRoleToUser(userId, roleIds);
        return "redirect:findAll";
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
        //1、根据用户id查询用户
        UserInfo userInfo = service.findById(userid);
        //2、根据用户id查询可以添加的角色
        List<Role> otherRoles = service.findOtherRoles(userid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save")
    @PreAuthorize("authentication.principal.username == 'coco'")//只有coco能添加
    public String save(UserInfo userInfo) throws Exception {
        service.save(userInfo);
        return "redirect:findAllUser";
    }

    @RequestMapping("findAllUser")
    @PreAuthorize("hasRole('ROLE_USER')")//只有ROLE_USER能访问
    public ModelAndView findAllUser() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = service.findAllUser();
        mv.addObject("userList", list);
        mv.setViewName("user-list");
        return mv;
    }


}
