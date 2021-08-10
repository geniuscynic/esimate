package com.xjjxmm.estimate.config.auth

import com.alibaba.fastjson.JSON
import com.xjjxmm.estimate.vo.ResponseData
import com.xjjxmm.estimate.vo.UserVo
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import utity.JwtKit
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JWTAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, authentication: Authentication) {

        authentication.principal?.let { principal->
            if(principal is UserVo) {
                //val user = principal as UserVo

                val token = JwtKit.createToken(principal)

                httpServletResponse.contentType = "application/json;charset=UTF-8"
                httpServletResponse.writer.write(JSON.toJSONString(ResponseData(data = token)))
            }
        }




    }
}