package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IRoleDAO;
import com.plantasun_ssm.domain.Permission;
import com.plantasun_ssm.domain.Role;
import com.plantasun_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDAO roleDAO;
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public List<Role> findOtherRoles(String uid) {
        return roleDAO.findOtherRoles(uid);
    }



    @Override
    public Role findRoleById(String id) {
        return roleDAO.findRoleById(id);
    }

    @Override
    public void addPermissionToRole(String id,String [] ids) {
        for (String permissionId : ids) {
            roleDAO.addPermissionToRole(id,permissionId);
        }
    }
}
