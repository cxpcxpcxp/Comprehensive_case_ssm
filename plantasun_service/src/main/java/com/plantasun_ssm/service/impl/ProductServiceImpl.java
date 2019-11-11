package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IProductDAO;
import com.plantasun_ssm.domain.Product;
import com.plantasun_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

}
