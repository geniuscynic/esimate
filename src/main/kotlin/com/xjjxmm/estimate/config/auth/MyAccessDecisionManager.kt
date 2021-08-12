package com.xjjxmm.estimate.config.auth

import org.springframework.security.access.AccessDecisionManager
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class MyAccessDecisionManager : AccessDecisionManager {
    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。

    override fun decide(authentication: Authentication, any : Any, configAttributes: MutableCollection<ConfigAttribute>?) {
        if(null== configAttributes || configAttributes.isEmpty()) {
            return
        }

        configAttributes.forEach { iter->
            val needRole = iter.attribute

            authentication.authorities.forEach { ga->
                if(needRole.trim() == ga.authority) {
                    return;
                }
            }
        }
    }

    override fun supports(attribute: ConfigAttribute): Boolean {
        return true;
    }

    override fun supports(clazz: Class<*>): Boolean {
        return true;
    }
}