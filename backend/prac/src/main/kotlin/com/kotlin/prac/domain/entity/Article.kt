package com.kotlin.prac.domain.entity

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@Getter
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //필드에 쓴 모든 생성자
@Entity
@Table(name = "board")
/**
 * entity에서는 data class의 사용은 지양
 * data class == lombok에서 지원하는 @Data 어노테이션과 비슷한 기능을 코틀린 언어에서 지원하는 것
 * equals()/hasCode(), toString(), copy() 자동 구현
 * 이와 같은 자동 구현을 entity에서 사용할 경우, 순환 참조의 문제가 생길 수 있다.
 */
class Article {
    @Id
    @Column(name="board_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // Entity를 final 클래스일 수 없다. 모든 메소드와 엔티티 내에 persist되는 변수들 또한 final로 지정할 수 없다.
    var id:Long? =null // ? = null 할당 가능

    @Column(name="board_title")
    var title:String=""

    @Column(name="board_contents")
    var contents:String=""

    @Column(name="board_writer", updatable=false)
    // 변경 가능성이 없는 필드
    val writer:String=""

    @Column(name="board_date", updatable=false)
    val date: LocalDateTime =LocalDateTime.now()
}