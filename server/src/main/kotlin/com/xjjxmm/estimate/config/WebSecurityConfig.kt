package com.xjjxmm.estimate.config

import com.xjjxmm.estimate.config.auth.JWTAuthenticationFailureHandler
import com.xjjxmm.estimate.config.auth.JWTAuthenticationSuccessHandler
import com.xjjxmm.estimate.config.auth.JWTAuthorizationFilter
import com.xjjxmm.estimate.config.auth.JwtAuthenticationEntryPoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import utity.RedisUtil


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var jwtAuthenticationSuccessHandler: JWTAuthenticationSuccessHandler

    @Autowired
    private lateinit var jwtAuthenticationFailureHandler: JWTAuthenticationFailureHandler

    @Autowired
    private lateinit var jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint

    //@Autowired
    //private lateinit var redisTemplate: RedisTemplate<String, Any>

    @Autowired
    private lateinit var redisUtil : RedisUtil

    override fun configure(http: HttpSecurity) {

       // super.configure(http)
        http.authorizeRequests()
            .antMatchers("/login2").hasAnyAuthority("test2")
            //.antMatchers("/login2").permitAll()
            .anyRequest().permitAll() // 允许所有请求通过
            .and()
            .formLogin()
            .successHandler(jwtAuthenticationSuccessHandler)
            .failureHandler(jwtAuthenticationFailureHandler)
            .permitAll()
            .and()
            .addFilterAfter(JWTAuthorizationFilter(redisUtil), UsernamePasswordAuthenticationFilter::class.java)
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


    @Bean
    fun redisUtil(redisTemplate: RedisTemplate<String, String>) : RedisUtil {
        return RedisUtil(redisTemplate)
    }
}