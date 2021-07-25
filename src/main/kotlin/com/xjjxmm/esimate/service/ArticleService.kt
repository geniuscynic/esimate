package com.xjjxmm.esimate.service

import com.xjjxmm.esimate.vo.ArticleVo

interface ArticleService {
    fun getArticles() : List<ArticleVo>
}