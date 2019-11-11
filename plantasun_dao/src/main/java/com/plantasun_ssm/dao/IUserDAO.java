package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface IUserDAO {
    @Select("select * from users where username=#{username}")
    public UserInfo findByUserName(String username);
}
