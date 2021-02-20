package com.inno.backoffice.security.service;

import com.inno.backoffice.admin.service.AdminService;
import com.inno.backoffice.admin.vo.AdminVO;
import com.inno.backoffice.security.vo.InnoUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InnoUserService implements UserDetailsService {

    @Resource
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(">>>> InnoUserService loadUserByUsername ................................ : "+username);
        try {
            AdminVO adminVO = adminService.selectAdminByUsername(username);
            if(adminVO == null){
                throw new UsernameNotFoundException(username);
            }
            return new InnoUser(adminVO);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
