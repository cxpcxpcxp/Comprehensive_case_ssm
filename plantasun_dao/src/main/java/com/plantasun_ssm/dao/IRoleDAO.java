package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Role;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from role")
    List<Role> findAll();

    @SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id not in(select roleId from users_role where userId=#{uid})")
    List<Role> findOtherRoles(String uid);
}
