package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDAO {
    @Select("select * from role where id in(select roleId from users_role where userId = #{id})")
    public List<Role> findRolesByUserId(String id);
//    三张表联查
    @Select("select * from role where id in (select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",
                    many = @Many(select = "com.plantasun_ssm.dao.IPermissionDAO.findPermissionByRoleId"))

    })
    public List<Role> findRoleByUserIds(String id);
}
