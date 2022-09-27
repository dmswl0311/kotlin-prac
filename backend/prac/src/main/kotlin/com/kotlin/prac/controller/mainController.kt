package com.kotlin.prac.controller

import com.kotlin.prac.domain.dto.ArticleDto
import com.kotlin.prac.domain.entity.Article
import com.kotlin.prac.service.mainService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest")
class mainController(private val service:mainService) {

    @GetMapping("/test")
    fun test():String{
        return "test"
    }

    /**
     * 전체 게시글 조회
     */
    @GetMapping("/all")
    fun getAllArticles():List<ArticleDto>{
        return service.getAllArticles()
    }
}