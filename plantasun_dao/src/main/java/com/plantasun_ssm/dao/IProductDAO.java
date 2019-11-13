package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface IProductDAO {
    @Select("select * from product")
    List<Product> findAll();

    @SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into " +
            "product(id,productNum,productName,cityName,DepartureTime,productPrice," +
            "productDesc,productStatus) " +
            "values(#{id},#{productNum},#{productName}," +
            "#{cityName},#{DepartureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id = #{id}")
    Product findProductById(String id);
}
