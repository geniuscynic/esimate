package com.xjjxmm.esimate.config

import com.xjjxmm.esimate.config.auth.JWTAuthenticationFailureHandler
import com.xjjxmm.esimate.config.auth.JWTAuthenticationSuccessHandler
import com.xjjxmm.esimate.config.auth.JWTAuthorizationFilter
import com.xjjxmm.esimate.config.auth.JwtAuthenticationEntryPoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var jwtAuthenticationSuccessHandler: JWTAuthenticationSuccessHandler

    @Autowired
    private lateinit var jwtAuthenticationFailureHandler: JWTAuthenticationFailureHandler

    @Autowired
    private lateinit var jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint

    override fun configure(http: HttpSecurity) {
       // super.configure(http)

        http.authorizeRequests()
            //.antMatchers("/login2").permitAll()
            .anyRequest().authenticated() //// 允许所有请求通过
            .and()
            .formLogin()
            .successHandler(jwtAuthenticationSuccessHandler)
            .failureHandler(jwtAuthenticationFailureHandler)
            .permitAll()
            .and()
            .addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
            //.and()
            .csrf().disable() // 禁用 Spring Security 自带的跨域处理
            .sessionManagement() // 定制我们自己的 session 策略
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
    }

    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}