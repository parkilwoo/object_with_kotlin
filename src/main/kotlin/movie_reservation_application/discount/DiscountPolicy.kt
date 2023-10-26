package movie_reservation_application.discount

import movie_reservation_application.Money
import movie_reservation_application.Screening

/**
 * NoneDiscountPolicy 클래스에서 getDiscountAmount() 메서드가 어떤값을 반환하더라도 상관이 없다.
 * 따라서 DiscountPolicy를 인터페이스로 바꾸고 NoneDiscountPolicy 클래스와 DefaultDiscountPolicy로 분기 후
 * 각각이 DiscountPolicy를 상속받을 수 있을 수 있게 한다.
 */
interface DiscountPolicy {
    /**
     * 할인정책을 구현체에서 공통적으로 구현해야 할 함수
     */
    fun calculateDiscountAmount(screening: Screening) : Money
}