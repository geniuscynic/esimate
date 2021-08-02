package com.xjjxmm.esimate.service.impl


import com.xjjxmm.esimate.vo.UserVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserDetailsService {
@Autowired
    lateinit var pw: PasswordEncoder

    /*
     * 功能描述 根据登入名查找用户
     * @author zjw
     * @date 2021/7/31
     * @param 登录名
     * @return 用户信息
     */
    override fun loadUserByUsername(userName: String?): UserDetails {

        if (userName.isNullOrBlank()) {
            throw  UsernameNotFoundException("用户名不能为空")
        }

        if (userName != "admin") {
            throw  UsernameNotFoundException("用户名错误")
        }

        val password = pw.encode("123456")

        return UserVo("1234567890","admin", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"))
    }
}