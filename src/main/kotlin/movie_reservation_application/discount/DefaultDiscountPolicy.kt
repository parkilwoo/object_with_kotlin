package movie_reservation_application.discount

import movie_reservation_application.Money
import movie_reservation_application.Screening

/**
 * 추상클래스 안에 중복코드를 넣고 AmountDiscountPolicy와 PercentDiscountPolicy가 이 클래스를 상속 받는다.
 * 이처럼 부모클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을 TEMPLATE METHOD 패턴 이라고 한다.
 *
 * DiscountPolicy 클래스에서 DefaultDiscountPolicy로 변환하여 할인정책이 있는 클래스만 해당 클래스를 상속받도록 한다.
 */
abstract class DefaultDiscountPolicy(
    vararg conditions: DiscountCondition
) : DiscountPolicy{
    /**
     * DiscountPolicy는 DiscountCondition의 리스트인 conditions를 인스턴스 변수로 가지기 때문에
     * 하나의 할인 정책이 여러 개의 할인 조건을 포함할 수 있다.
     */
    private var conditions: List<DiscountCondition> = listOf(*conditions)


    /**
     * 전체 할인 조건에 대해 차례대로 DiscountCondition의 isSatisfiedBy 메서드를 호출한다.
     */
    override fun calculateDiscountAmount(screening: Screening): Money {
        for (each: DiscountCondition in conditions) {
            if(each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}