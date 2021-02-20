package com.inno.backoffice.security.vo;

import com.inno.backoffice.admin.vo.AdminVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InnoUser implements UserDetails {

    private AdminVO adminVO;

    public InnoUser(AdminVO adminVO) {
        this.adminVO = adminVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> result = new ArrayList<>();
        if(adminVO != null){
            result.add(new SimpleGrantedAuthority(adminVO.getAuthSn()));
        }
        return result;
    }

    public AdminVO getAdminVO() {
        return adminVO;
    }

    @Override
    public String getPassword() {
        return adminVO == null? null : adminVO.getAdminPw();
    }
    @Override
    public String getUsername() {
        return adminVO == null? null : adminVO.getAdminId();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
