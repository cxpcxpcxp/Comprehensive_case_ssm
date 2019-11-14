package com.plantasun_ssm.web;

import com.plantasun_ssm.domain.Role;
import com.plantasun_ssm.domain.UserInfo;
import com.plantasun_ssm.service.IRoleService;
import com.plantasun_ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList =  userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("findUserByIdAndOtherRole.do")
    public ModelAndView findUserByIdAndOtherRole(String id){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findOtherRoles(id);
        UserInfo user = userService.findById(id);
        mv.addObject("roleList",roleList);
        mv.addObject("user",user);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(String userId,String[] ids){
        userService.addRolesToUser(userId,ids);
        return "redirect:findAll.do";
    }

}
