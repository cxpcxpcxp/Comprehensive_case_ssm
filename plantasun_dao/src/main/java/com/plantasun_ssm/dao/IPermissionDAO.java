package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface IPermissionDAO {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id);

    @Select("select * from permission")
    List<Permission> findAll();


    @SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
