package com.plantasun_ssm.service;

import com.plantasun_ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    void save(Role role);
}
