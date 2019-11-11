package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
}
