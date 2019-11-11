package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDAO {
    @Select("select * from product")
    List<Product> findAll();
}
