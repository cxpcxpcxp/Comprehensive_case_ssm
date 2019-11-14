package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IUserDAO;
import com.plantasun_ssm.domain.Role;
import com.plantasun_ssm.domain.UserInfo;
import com.plantasun_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        返回的是一个User对象
        UserInfo userInfo = userDAO.findByUserName(username);
        User user = new User(userInfo.getUsername(),
                "{noop}"+userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,
                true,
                true,
                true,
                getAuthority(userInfo.getRole()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userDAO.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public void addRolesToUser(String userId, String[] ids) {
        for (String roleId : ids) {
            userDAO.addRolsToUser(userId,roleId);
        }
    }
}
