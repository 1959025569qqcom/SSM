package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private IPermissionService service;

    @RequestMapping("findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> list = service.findAll();
        mv.addObject("permissionList", list);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save")
    public String save(Permission permission) throws Exception {
        service.save(permission);
        return "redirect:findAll";
    }
}
