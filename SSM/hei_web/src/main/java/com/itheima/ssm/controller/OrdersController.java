package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService service;

    //    @RequestMapping("findAll")
//    public ModelAndView findAll()throws Exception{
//        ModelAndView mv=new ModelAndView();
//        List<Orders> all = service.findAll();
//        mv.addObject("ordersList",all);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = service.findAll(page, size);
        //pageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
