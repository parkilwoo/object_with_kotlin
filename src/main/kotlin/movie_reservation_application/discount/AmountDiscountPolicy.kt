package movie_reservation_application.discount

import movie_reservation_application.Money
import movie_reservation_application.Screening

/**
 * DiscountPolicy의 자식 클래스
 * 할인 조건을 만족할 경우 일정한 금액을 할인해주는 금액 할인 정책을 구현한다.
 */
class AmountDefaultDiscountPolicy(
    private var discountAmount: Money,
    vararg conditions: DiscountCondition
) : DefaultDiscountPolicy(*conditions) {
    /**
     * getDiscountAmount 함수를 오버라이딩하여 구현한다.
     * 할인금액을 Return
     */
    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}