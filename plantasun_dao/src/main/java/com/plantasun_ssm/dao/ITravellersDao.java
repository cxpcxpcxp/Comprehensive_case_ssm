package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellersDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{id})")
    public List<Traveller> findTravellersByOrdersId(String id);
}
