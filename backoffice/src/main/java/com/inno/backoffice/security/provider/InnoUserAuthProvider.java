package com.inno.backoffice.security.provider;

import com.inno.backoffice.security.service.InnoUserService;
import com.inno.backoffice.security.vo.InnoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class InnoUserAuthProvider implements AuthenticationProvider {

    @Autowired
    private InnoUserService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println(">>>>> InnoUserAuthProvider authenticate...."+authentication);
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        try {
            // 운영자 조회
            InnoUser user = (InnoUser) service.loadUserByUsername(username);

            // 존재하지 않는 아이디일 때 던지는 예외
            if(user == null){
                throw new InternalAuthenticationServiceException(username);
            }

            // 비밀번호가 일치하지 않을 때 던지는 예외
            if(!password.equals(user.getPassword())){
                throw new BadCredentialsException("Wrong Password");
            }

            // 인증 요구가 거부됐을 때 던지는 예외
            if(!user.isEnabled() || !user.isCredentialsNonExpired()) {
                throw new AuthenticationCredentialsNotFoundException(username);
            }

            return new UsernamePasswordAuthenticationToken(user,password,user.getAuthorities());
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
