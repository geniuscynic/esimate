package com.xjjxmm.estimate.controller

import com.xjjxmm.estimate.service.ArticleService
import com.xjjxmm.estimate.vo.ArticleVo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("articles")
class ArticleController(val articleService : ArticleService) {


    @GetMapping
    fun articles() : List<ArticleVo> {
        return articleService.getArticles();
    }
}