package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysController {
    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("findAll")
    public ModelAndView findAll(SysLog sysLog)throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> list = sysLogService.findAll(sysLog);
        mv.addObject("sysLogs",list);
        mv.setViewName("syslog-list");
        return mv;
    }
}
