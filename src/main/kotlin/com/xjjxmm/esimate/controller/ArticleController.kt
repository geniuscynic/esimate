package com.xjjxmm.esimate.controller

import com.xjjxmm.esimate.service.ArticleService
import com.xjjxmm.esimate.vo.ArticleVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("articles")
class ArticleController(val articleService : ArticleService) {


    @GetMapping
    fun articles() : List<ArticleVo> {
        return articleService.getArticles();
    }
}