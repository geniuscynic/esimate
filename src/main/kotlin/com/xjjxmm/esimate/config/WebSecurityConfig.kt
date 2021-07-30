package com.xjjxmm.esimate.config

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
       // super.configure(http)

        http?.authorizeRequests()
           // ?.antMatchers("/auth")?.authenticated()
            ?.anyRequest()?.permitAll() //// 允许所有请求通过
            ?.and()
            ?.csrf()?.disable() // 禁用 Spring Security 自带的跨域处理
            ?.sessionManagement() // 定制我们自己的 session 策略
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}