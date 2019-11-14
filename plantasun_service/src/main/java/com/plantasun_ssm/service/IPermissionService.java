package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
