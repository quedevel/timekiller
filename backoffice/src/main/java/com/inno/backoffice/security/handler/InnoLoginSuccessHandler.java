package com.inno.backoffice.security.handler;

import com.inno.backoffice.security.vo.InnoUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InnoLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        InnoUser user = (InnoUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        session.setAttribute("user", user.getAdminVO());

        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        //we will redirect the user after successfully login
        response.sendRedirect("/");
    }
}
