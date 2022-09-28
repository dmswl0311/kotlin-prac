package com.kotlin.prac.service

import com.kotlin.prac.domain.dto.ArticleDto
import com.kotlin.prac.domain.entity.Article
import com.kotlin.prac.repository.mainRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class mainService(private val repo:mainRepo) {
    fun getAllArticles():List<ArticleDto>{
        val list:List<Article> = repo.findAllBy()
        /**
         * 코틀린의 Collection은 기본적으로 Mutable(변할 수 없는)과 Immutable(불변의)을 별개로 지원한다.
         * Mutable로 생성하면 추가, 삭제가 가능하지만, Immutable로 생성하면 수정이 불가하다.
         * <List>
         * Immutable > listOf<타입>(아이템,...)
         * ex) val fruits= listOf<String>("apple", "banana", "kiwi", "peach")
         * Mutable > mutableListOf<타입>(아이템,...)
         * ex) val fruits= mutableListOf<String>("apple", "banana", "kiwi", "peach")
         */
        val res = mutableListOf<ArticleDto>()
        /**
         * 코틀린의 for문
         *
         * for(i in 1..10)
         * 몇부터 몇까지 특정 범위를 표현할 때 숫자 사이에 점 두 개 (..)를 이용한다.
         *
         * 특정 컬렉션타입의 데이터 개수만큼 for문 반복
         * ex) for(str in list)
         *
         * 특정 컬렉션타입에서 인덱스값을 이용 > indices 프로퍼티 사용
         * ex) for(i in list.indices)
         *       list[i]
         */
        for (article in list){
            val temp=ArticleDto(article.id,article.title,article.contents,article.writer,article.date)
            res.add(temp)
        }
        return res
    }

    fun getArticle(articleId:Long) : Any {
        var res: Optional<Article> =repo.findById(articleId)
        if(res.isPresent) {
            var article: Article = res.get()
            return ArticleDto(article.id, article.title, article.contents, article.writer, article.date)
        }
        /**
         * exception의 종류 두 가지
         * 1. checked exception (컴파일 시점에서 예외 발생 / FileNotFoundException, ClassNotFoundException 등...)
         * 2. unchecked exception(RuntimeException / NullPointerExcpetion,ArrayIndexOutOfBoundsException 등...) (컴파일 o)
         *
         * ResponseStatusException 은 @ResponseStatus 의 대체제로 Spring 5에 등장했다.
         * RuntimeException을 상속하며 마찬가지로 HTTP Status 와 Message 를 설정할 수 있다.
         */
         throw ResponseStatusException(HttpStatus.BAD_REQUEST,"해당하는 게시글이 없습니다.",NullPointerException())
    }
}