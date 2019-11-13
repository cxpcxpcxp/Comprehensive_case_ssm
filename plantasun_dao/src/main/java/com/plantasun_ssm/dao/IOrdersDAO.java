package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Orders;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrdersDAO {
    @Select("select * from Orders ")
    @Results({
            @Result(id = true, column = "id" ,property = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(column = "orderTime" ,property = "orderTime"),
            @Result(column = "orderStatus" ,property = "orderStatus"),
            @Result(column = "peopleCount" ,property = "peopleCount"),
            @Result(column = "payType" ,property = "payType"),
            @Result(column = "orderDesc" ,property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.plantasun_ssm.dao.IProductDAO.findProductById"))

    })
    public List<Orders> findAll();
}
