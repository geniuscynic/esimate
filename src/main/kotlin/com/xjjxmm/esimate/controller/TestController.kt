package com.xjjxmm.esimate.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @RequestMapping("/login2")
    fun login() : String {
        return "login"
    }
}