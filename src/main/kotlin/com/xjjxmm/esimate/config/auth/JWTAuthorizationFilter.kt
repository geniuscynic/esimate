package com.xjjxmm.esimate.config.auth

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import utity.JwtKit
import utity.RedisUtil
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthorizationFilter(private val redisUtil : RedisUtil) : OncePerRequestFilter() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val token = getTokenFromRequestHeader(request)
        if(token == null) {
            //response.contentType = "application/json;charset=UTF-8"
            //response.writer.write(JSON.toJSONString(ResponseData(message = "错误的token")))
            chain.doFilter(request, response)
            return
        }
        val verifyResult: Authentication = verifyToken(token)

            log.info("token令牌验证成功")
            SecurityContextHolder.getContext().authentication = verifyResult
            chain.doFilter(request, response)

    }

    // 从请求头获取token
    private fun getTokenFromRequestHeader(request: HttpServletRequest): String? {
        val header = request.getHeader(JwtKit.TOKEN_HEADER)
        if (header == null || !header.startsWith(JwtKit.TOKEN_PREFIX)) {
            log.info("请求头不含JWT token， 调用下个过滤器")
            return null
        }
        return header.substring(JwtKit.TOKEN_PREFIX.length).trim()
    }



    // 验证token，并生成认证后的token
    private fun verifyToken(token: String): UsernamePasswordAuthenticationToken {

        val claim = JwtKit.parseJwt(token)
        // 提取用户名
        val username: String = claim.id
        redisUtil.set("user", username, 60)
        // 定义权限列表
        val authorities: MutableList<GrantedAuthority> = AuthorityUtils.commaSeparatedStringToAuthorityList("admin1,normal1")
       /* // 从token提取角色
        val roles: List<String> = JWTUtil.getRole(token)
        for (role in roles) {
            log.info("用户身份是:$role")
            authorities.add(SimpleGrantedAuthority(role))
        }*/
        // 构建认证过的token
        return UsernamePasswordAuthenticationToken("admin1", "password1", authorities)
    }
}