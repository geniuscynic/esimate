package com.xjjxmm.esimate.service.impl

import com.xjjxmm.esimate.repository.mapper.ArticleMapper
import com.xjjxmm.esimate.service.ArticleService
import com.xjjxmm.esimate.vo.ArticleVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import utity.MappingKit.mapper

@Service
class ArticleServiceImpl() : ArticleService {

    @Autowired
    lateinit var articleMapper: ArticleMapper

    override fun getArticles(): List<ArticleVo> {
        val articles = articleMapper.selectList(null)
        //val artiles : MutableList<ArticleVo> = mutableListOf()

        /* result.forEach {
            val article = ArticleVo()
            BeanUtils.copyProperties(it, article)

            artiles.add(article)
        }*/

        //val artiles = copyList(::ArticleVo, result)

        //return result.mapper(::ArticleVo)

        return articles.mapper()

    }
//KMapper



}