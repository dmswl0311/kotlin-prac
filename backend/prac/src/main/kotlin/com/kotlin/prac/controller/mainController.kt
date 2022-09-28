package com.kotlin.prac.controller

import com.kotlin.prac.domain.dto.ArticleDto
import com.kotlin.prac.service.mainService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
@Api(tags=["게시판 REST API"])
class mainController(private val service:mainService) {

    // swagger http://localhost:8080/swagger-ui/
    @GetMapping("/test")
    fun test():String{
        return "test"
    }

    @ApiOperation("전체 게시글 조회")
    @ApiResponse(code = 200, message = "성공입니다.")
    @GetMapping("/all")
    fun getAllArticles():ResponseEntity<List<ArticleDto>>{
        var res:List<ArticleDto> = service.getAllArticles()
        return ResponseEntity.ok().body(res)
    }

    /**
     * @ResponseStatus(value=HttpStatus.BAD_REQUEST,code=HttpStatus.BAD_REQUEST, reason = "해당하는 게시글이 없습니다.")
     * @ResponseStatus 개발자가 정의한 Exception 이 발생하면 해당 Status 와 Message 를 전달한다.
     * 애노테이션을 사용하기 때문에 조건에 따라 동적으로 변경 하기가 어렵다.
     */

    /**
     * Any?
     * 자바의 최상위 클래스가 Object라면, 코틀린은 Any이다.
     * 단순힌 이름만 바뀐 것이 아니다. 코틀린에서도 Object를 사용할 수 있지만, 최상위 클래스는 아니다. Any는 Object의 슈퍼 클래스이다.
     * 자바에서 기본형 타입(int,long)과 같은 값들을 Object에 대입하려면 참조형 타입으로 변환해야 한다. 하지만 코틀린의 Any는 int과 같은 타입을 클래스로 취급하기 때문에 그대로 대입할 수 있다.
     * ! Any에 대입할 수 없는 값 == null --> Any는 Int?처럼 Nullable Type은 대입할 수 없다.
     * 코틀린에는 모든 값을 저장할 수 있는 최상위 오브젝트로 Any?가 존재한다.
     */
    @ApiOperation("게시글 상세 조회")
    // 가변 인자
    @ApiResponses(
        ApiResponse(code = 200, message = "성공입니다."),
        ApiResponse(code = 400, message = "실패입니다."),
    )
    @GetMapping("/article/{id}")
    fun getArticle(@ApiParam(value="게시글 아이디") @PathVariable("id") articleId: Long): ResponseEntity<Any> {
        var res:Any=service.getArticle(articleId)
        return ResponseEntity.ok().body(res)
    }
}