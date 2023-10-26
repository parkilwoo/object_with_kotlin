package movie_reservation_application

import movie_reservation_application.discount.DefaultDiscountPolicy
import movie_reservation_application.discount.DiscountPolicy
import java.time.Duration

/**
 * 영화 클래스
 * 제목, 상영시간, 기본요금, 할인 정책을 속성으로 가진다.
 */
class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private var discountPolicy: DiscountPolicy
) {
    fun getFee(): Money {
        return fee
    }

    /**
     * discountPolicy에 calculateDiscountAmount 메시지를 전송해 할인 요금을 반환받는다.
     */
    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening))
    }

    /**
     * 합성(Composition)을 이용하여서 객체의 변경이 간단하게 가능하다.
     * 금액 할인 정책이 적용된 영화에서 다른 할인 정책으로 변경한다.
     */
    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }
}