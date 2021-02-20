package com.inno.backoffice.config;

import com.inno.backoffice.auth.service.AuthService;
import com.inno.backoffice.auth.vo.AuthVO;
import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.backoffice.security.provider.InnoUserAuthProvider;
import com.inno.backoffice.security.vo.InnoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private InnoUserAuthProvider provider;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AuthService authService;

    /**
     * 스프링 시큐리티 규칙 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 등록된 URL Security 적용
        this.matchUrlAndAuthority(http);

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()  // 로그인은 모두 접근 가능
                .anyRequest().authenticated() // 권한 부여자만 접근 가능
            .and()
                .exceptionHandling()
                .accessDeniedPage("/login")    // 권한 없는 유저 페이지
            .and()
                .authenticationProvider(provider)
                .formLogin()
                .loginPage("/login")
                //.loginProcessingUrl("/authenticateUser")
                .usernameParameter("username")   // 아이디 파라미터 name
                .passwordParameter("password")        // 비밀번호 파라미터 name
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그 아웃  URL
                .logoutSuccessUrl("/login") // 로그 아웃 후 URL
                .invalidateHttpSession(true) // 세션 만료
            ;  // csrf 설정
    }

    /**
     * 정적 파일의 경우, 인증/인가 절차를 무시하도록 설정
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**")
            .antMatchers("/css/**")
            .antMatchers("/vendor/**")
            .antMatchers("/js/**")
            .antMatchers("/img/**");
    }

    /**
     * URL에 권한 있는지 확인
     * @param request
     * @param authentication
     * @return
     */
    private boolean urlCheck(HttpServletRequest request, Authentication authentication) {
        Object o = authentication.getPrincipal();

        if(!(o instanceof InnoUser)){
            return false;
        }

        InnoUser user = (InnoUser) o;
        return false;
    }

    /**
     * 등록된 URL과 권한 Security 적용
     * @param http
     * @throws Exception
     */
    private void matchUrlAndAuthority(HttpSecurity http) throws Exception {
        String[] urlList = menuService.selectAllMenu(); // 모든 메뉴 리스트 ( 공백 URL이 존재하면 안됨 )
        List<AuthVO> authList = authService.authList();
        for(AuthVO aVO : authList){
            http.authorizeRequests().antMatchers(urlList).hasAuthority(aVO.getAuthSn());
        }
    }



}
