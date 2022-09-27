package com.kotlin.prac.service

import com.kotlin.prac.domain.entity.Article
import com.kotlin.prac.repository.mainRepo
import org.springframework.stereotype.Service

@Service
class mainService(private val repo:mainRepo) {
    fun getAllArticles():List<Article>{
        val list:List<Article> = repo.findAllBy()
        return list
    }
}