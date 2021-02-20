package com.inno.backoffice.config;

import com.inno.backoffice.admin.service.AdminService;
import com.inno.backoffice.admin.vo.AdminVO;
import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.backoffice.security.vo.InnoUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorizationChecker {

    @Resource
    private MenuService menuService;

    /**
     * URL 권한 검사 추가
     * @param request
     * @param authentication
     * @return
     * @throws Exception
     */
    public boolean check(HttpServletRequest request, Authentication authentication) throws Exception {
        Object principalObj = authentication.getPrincipal();

        if (!(principalObj instanceof InnoUser)) {
            return false;
        }

        List<String> authority = new ArrayList<>();
        for (MenuVO m : menuService.selectAllMenu()) {
            if (new AntPathMatcher().match(m.getMenuUrl(), request.getRequestURI())) {
                authority.add(m.getAuthSn());
            }
        }

        InnoUser user = (InnoUser)authentication.getPrincipal();
        AdminVO adminVO = user.getAdminVO();
        if (authority.isEmpty() || adminVO == null || !authority.contains(adminVO.getAuthSn())) {
            return false;
        }
        return true;
    }
}
