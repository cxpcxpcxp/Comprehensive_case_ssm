package com.plantasun_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.plantasun_ssm.dao.IOrdersDAO;
import com.plantasun_ssm.domain.Orders;
import com.plantasun_ssm.service.IOdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class OrdersServiceImpl implements IOdersService {
    @Autowired
    IOrdersDAO ordersDAO;
    @Override
    public List<Orders> findAll(int page,int pageSize) {
//        开启分页插件
        PageHelper.startPage(page,pageSize);
        return ordersDAO.findAll();
    }

}
