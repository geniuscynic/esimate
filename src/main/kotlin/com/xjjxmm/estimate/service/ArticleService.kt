package com.xjjxmm.estimate.service

import com.xjjxmm.estimate.vo.ArticleVo

interface ArticleService {
    fun getArticles() : List<ArticleVo>
}