package com.inno.backoffice.config;

import com.inno.backoffice.menu.service.MenuService;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.backoffice.security.provider.InnoUserAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.ObjectUtils;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private InnoUserAuthProvider provider;

    @Autowired
    private MenuService menuService;

    /**
     * 스프링 시큐리티 규칙 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 등록된 URL Security 적용
        //this.matchUrlAndAuthority(http);

        http.csrf().disable()// csrf 설정
                .authorizeRequests()
                .antMatchers("/login").anonymous()  // 로그인은 모두 접근 가능
                .anyRequest()
                //.permitAll()
                .access("@authorizationChecker.check(request, authentication)")// URL 접근 처리 ( cash 처리 필요 )
//            .and()
//                .exceptionHandling()
//                .accessDeniedPage("/login")    // 권한 없는 유저 페이지
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
            ;
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
     * 등록된 URL과 권한 Security 적용
     * @param http
     * @throws Exception
     */
    private void matchUrlAndAuthority(HttpSecurity http) throws Exception {
        List<MenuVO> menuList = menuService.selectMenuUrlGroupByAuthSn();
        // 권한 일련번호로 메뉴 URL 등록
        for(MenuVO mVO : menuList){
            if(ObjectUtils.isEmpty(mVO.getMenuUrlList())){
                http.authorizeRequests().antMatchers("/","/index").hasAuthority(mVO.getAuthSn());
                http.authorizeRequests().antMatchers(mVO.getMenuUrlList()).hasAuthority(mVO.getAuthSn());
            }
        }
    }

}
