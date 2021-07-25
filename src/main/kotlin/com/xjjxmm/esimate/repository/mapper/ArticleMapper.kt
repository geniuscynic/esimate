package com.xjjxmm.esimate.repository.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.xjjxmm.esimate.repository.pojo.Article



interface ArticleMapper : BaseMapper<Article>
{
    //@Select("select * from ms_article")
    //fun getArticles(): List<Article>
}