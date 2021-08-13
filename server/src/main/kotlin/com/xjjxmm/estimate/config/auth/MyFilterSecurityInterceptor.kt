package com.xjjxmm.estimate.config.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.SecurityMetadataSource
import org.springframework.security.access.intercept.AbstractSecurityInterceptor
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse


class MyFilterSecurityInterceptor : AbstractSecurityInterceptor(), Filter {
    @Autowired
    lateinit var securityMetadataSource: FilterInvocationSecurityMetadataSource

    override fun getSecureObjectClass(): Class<*> {
        TODO("Not yet implemented")
    }

    override fun obtainSecurityMetadataSource(): SecurityMetadataSource {
        TODO("Not yet implemented")
    }

    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
        TODO("Not yet implemented")
    }
}