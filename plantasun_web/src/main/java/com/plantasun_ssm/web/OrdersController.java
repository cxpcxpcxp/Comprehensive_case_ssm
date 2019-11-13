package com.plantasun_ssm.web;

import com.github.pagehelper.PageInfo;
import com.plantasun_ssm.domain.Orders;
import com.plantasun_ssm.service.IOdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//查询的不仅仅只是订单信息，
// 还需要将订单对应的产品信息也要查询出来，
// 所以说这是一个订单表与产品表的多表查询的操作
@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    IOdersService odersService;
//    一个订单对应一个产品
    @RequestMapping("findAll.do")
    public ModelAndView findAll
    (@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
     @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = odersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }


}
