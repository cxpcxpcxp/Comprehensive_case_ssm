package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Orders;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum" ,property = "orderNum"),
            @Result(column = "orderTime" ,property = "orderTime"),
            @Result(column = "orderStatus" ,property = "orderStatus"),
            @Result(column = "peopleCount" ,property = "peopleCount"),
            @Result(column = "payType" ,property = "payType"),
            @Result(column = "orderDesc" ,property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select = "com.plantasun_ssm.dao.IProductDAO.findProductById")),
            @Result(column = "memberId",property = "member",
                    one = @One(select = "com.plantasun_ssm.dao.IMemberDAO.findMemberById")),
            @Result(column = "id",property = "travellers",
                    many = @Many(select = "com.plantasun_ssm.dao.ITravellersDao.findTravellersByOrdersId"))
    })
    public Orders findById(String id);
}
