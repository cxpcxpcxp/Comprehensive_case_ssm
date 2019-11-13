package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.Orders;

import java.util.List;

public interface IOdersService {
    public List<Orders> findAll(int page ,int pageSize);

    Orders findById(String id);
}
