package com.kotlin.prac.controller

import com.kotlin.prac.domain.dto.ArticleDto
import com.kotlin.prac.service.mainService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

    /**
     * 게시글 상세 조회
     */

    /**
     * @ResponseStatus(value=HttpStatus.BAD_REQUEST,code=HttpStatus.BAD_REQUEST, reason = "해당하는 게시글이 없습니다.")
     * @ResponseStatus 개발자가 정의한 Exception 이 발생하면 해당 Status 와 Message 를 전달한다.
     * 애노테이션을 사용하기 때문에 조건에 따라 동적으로 변경 하기가 어렵다.
     */
    @GetMapping("/article/{id}")
    fun getArticle(@PathVariable("id") articleId: Long): Any {
        return service.getArticle(articleId)
    }
}