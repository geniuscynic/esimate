package com.xjjxmm.estimate


import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//http://localhost:8888/swagger-ui/index.html

@SpringBootApplication
@MapperScan("com.xjjxmm.estimate.repository.mapper", "com.xjjxmm.esimate.auth.dao")
class HelloworldApplication

fun main(args: Array<String>) {
    runApplication<HelloworldApplication>(*args)
}
