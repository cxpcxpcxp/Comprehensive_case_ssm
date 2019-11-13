package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDAO {
    @Select("select * from role where id in(select roleId from users_role where userId = #{id})")
    public List<Role> findRolesByUserId(String id);
}
