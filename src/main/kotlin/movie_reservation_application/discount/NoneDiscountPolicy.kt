package movie_reservation_application.discount

import movie_reservation_application.Money
import movie_reservation_application.Screening

/**
 * DiscountPolicy의 자식 클래스
 * 할인정책이 없을경우 Movie 클래스를 if로 처리할경우 책임의 위치가 모호해지고 설계 측면에서 좋지 않다.
 * 따라서 할인 요금을 계산할 책임을 DiscountPolicy에 그대로 유지시키는 방법으로 할인정책이 없을때의 자식 클래스를 추가한다.
 *
 * 부모클래스인 DiscountPolicy에서 할인 조건이 없을 경우에는 getDiscountAmount() 메서드를 호출하지 않는다.
 * 이것은 부모클래스인 DiscountPolicy와 NoneDiscountPolicy를 개념적으로 결합시킨다.
 * 이걸 해결하기 위해 DiscountPolicy를 인터페이스로 정의하고 getDiscountAmount() 메서드가 아닌 calculateDiscountAmount()를 호출한다.
 */
class NoneDiscountPolicy : DiscountPolicy {
//    override fun getDiscountAmount(screening: Screening): Money {
//        return Money.ZERO
//    }

    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}