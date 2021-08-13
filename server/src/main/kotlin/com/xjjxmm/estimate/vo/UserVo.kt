package com.xjjxmm.estimate.vo

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority

/**
 * @author zjw
 * @description 自定义用户类
 * @date 2021/8/1
 */
class AddUserVo(
    val userName: String,
    val password: String,
    val roles: List<String>
)

/**
 * @author zjw
 * @description 自定义用户类
 * @date 2021/8/1
 */
class UserVo(
    val id:String,
    private val userName: String,
    private val password: String,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return userName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}