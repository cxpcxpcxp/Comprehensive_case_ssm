package com.plantasun_ssm.web;

import com.plantasun_ssm.domain.Permission;
import com.plantasun_ssm.domain.Role;
import com.plantasun_ssm.service.IPermissionService;
import com.plantasun_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    IRoleService roleService;
    @Autowired
    IPermissionService permissionService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("findPermissionByRoleId.do")
    public ModelAndView findPermissionByRoleId(String id){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findOtherPermission(id);
        Role role = roleService.findRoleById(id);
        mv.addObject("permissionList",permissionList);
        mv.addObject("role",role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(String roleId,String [] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleById(id);
        mv.addObject("role",role);
        mv.setViewName("user-list");
        return mv;
    }
}
