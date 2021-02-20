package com.inno.backoffice.security.provider;


import com.inno.backoffice.admin.service.AdminService;
import com.inno.backoffice.admin.vo.AdminVO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class InnoUserAuthProvider implements AuthenticationProvider {

    @Resource
    private AdminService adminService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println(">>>>> InnoUserAuthProvider authenticate...."+authentication);
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        try {
            AdminVO adminVO = adminService.selectAdminByUsername(username);

            if(adminVO == null){
                return null;
            }
            if(!password.equals(adminVO.getAdminPw())){
                throw new BadCredentialsException("Wrong Password");
            }

            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            grantedAuthorityList.add(new SimpleGrantedAuthority(adminVO.getAuthSn()));

            return new UsernamePasswordAuthenticationToken(username,password,grantedAuthorityList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
