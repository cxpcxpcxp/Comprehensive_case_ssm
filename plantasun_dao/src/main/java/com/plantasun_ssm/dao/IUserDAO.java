package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDAO {
//    进行相关的修改，不仅仅只查询用户信息，用户角色信息也应该查询出来
//    user-role是多对多的查询
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "email",property = "email"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "role",
                    many = @Many(select = "com.plantasun_ssm.dao.IRoleDAO.findRolesByUserId"))
    })
    public UserInfo findByUserName(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @SelectKey(keyProperty = "id",resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '')")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into users values(#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "role",
                    many = @Many(select = "com.plantasun_ssm.dao.IRoleDAO.findRoleByUserIds"))
    })
    UserInfo findById(String id);

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRolsToUser(@Param(value = "userId") String userId, @Param(value = "roleId") String roleId);
}
