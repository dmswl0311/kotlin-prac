package com.kotlin.prac.domain.dto

import com.kotlin.prac.domain.entity.Article
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
data class ArticleDto(
    val id: Long?=null,
    val title: String,
    val contents: String,
    val writer: String,
    val date: LocalDateTime?=null
){
//    fun of(article:Article): ArticleDto{
//        val res=ArticleDto(article.id,article.title,article.contents,article.writer,article.date)
//        return res
//    }
}