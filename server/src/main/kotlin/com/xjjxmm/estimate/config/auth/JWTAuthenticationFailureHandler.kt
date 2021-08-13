package com.xjjxmm.estimate.config.auth

import com.alibaba.fastjson.JSON
import com.xjjxmm.estimate.vo.ResponseData
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JWTAuthenticationFailureHandler : AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        exception: AuthenticationException
    ) {
        httpServletResponse.contentType = "application/json;charset=UTF-8"
        httpServletResponse.outputStream.println(JSON.toJSONString(ResponseData(code = 401, message = "登入失败")))
    }
}