package kr.co.gongguiljeong.config.auth;

import kr.co.gongguiljeong.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/fonts/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/gongguiljeong-admin").permitAll()
                .antMatchers("/api/user/**").hasRole(Role.USER.name())
                .antMatchers("/category/**", "/brand/**", "/influencer/**", "/api/admin/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login().loginPage("/")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}