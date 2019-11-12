package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IProductDAO;
import com.plantasun_ssm.domain.Product;
import com.plantasun_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

}
