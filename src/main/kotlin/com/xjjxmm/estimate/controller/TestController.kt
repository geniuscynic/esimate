package com.xjjxmm.estimate.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @RequestMapping("/login2")
    fun login() : String {
        return "login2"
    }

    @RequestMapping("/login3")
    fun login2() : String {
        return "login3"
    }
}