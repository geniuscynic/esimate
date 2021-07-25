package com.xjjxmm.esimate.vo

data class ArticleVo (
    //    @JsonSerialize(using = ToStringSerializer.class)
    var id: Long?=null,

    var comment_counts: Int?=null,

    var create_date: Long??=null,

    var summary: String?=null,

    var title: String?=null,

    var view_counts: Int?=null,


    var weight: Int?=null,

    var author_id: Long?=null,

    var body_id: Long?=null,

    var category_id: Int?=null,


    //val body: ArticleBodyVo?,

    //val tags: List<TagVo>?,

    //val category: CategoryVo?,
)