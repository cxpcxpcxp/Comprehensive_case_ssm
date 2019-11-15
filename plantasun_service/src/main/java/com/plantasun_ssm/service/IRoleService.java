package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.Permission;
import com.plantasun_ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRoles(String uid);


    Role findRoleById(String id);

    void addPermissionToRole(String id,String [] ids);
}
