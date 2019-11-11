package com.plantasun_ssm.service.impl;

import com.plantasun_ssm.dao.IUserDAO;
import com.plantasun_ssm.domain.UserInfo;
import com.plantasun_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        返回的是一个User对象
        UserInfo userInfo = userDAO.findByUserName(username);
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority());
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
