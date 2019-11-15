package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IPermissionDAO;
import com.plantasun_ssm.domain.Permission;
import com.plantasun_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDAO permissionDAO;
    @Override
    public List<Permission> findAll() {
        return permissionDAO.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDAO.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return permissionDAO.findOtherPermission(id);
    }
}
