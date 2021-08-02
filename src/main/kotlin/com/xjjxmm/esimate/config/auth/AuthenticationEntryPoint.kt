package com.xjjxmm.esimate.config.auth

import com.alibaba.fastjson.JSON
import com.xjjxmm.esimate.vo.ResponseData
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint {
    /**
     * Commences an authentication scheme.
     *
     *
     * `ExceptionTranslationFilter` will populate the `HttpSession`
     * attribute named
     * `AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY`
     * with the requested target URL before calling this method.
     *
     *
     * Implementations should modify the headers on the `ServletResponse` as
     * necessary to commence the authentication process.
     * @param request that resulted in an `AuthenticationException`
     * @param response so that the user agent can begin authentication
     * @param authException that caused the invocation
     */
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.contentType = "application/json;charset=UTF-8"
        response.writer.write(JSON.toJSONString(JSON.toJSONString(ResponseData(code = 401, message = "没有权限", data = authException))))
    }
}