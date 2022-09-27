package com.kotlin.prac.repository

import com.kotlin.prac.domain.entity.Article
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
// 코틀린에서는 상속과 구현을 모두 : 로 표현한다
interface mainRepo: CrudRepository<Article, Long> {
    fun findAllBy():List<Article>
}