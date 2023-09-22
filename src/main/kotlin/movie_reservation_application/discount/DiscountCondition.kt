package movie_reservation_application.discount

import movie_reservation_application.Screening

/**
 * 할인에 관련된 공통 기능을 담은 인터페이스
 */
interface DiscountCondition {
    /**
     * 인자로 전달된 screenin이 할인이 가능한경우 true 아닐경우 false 응답
     */
    fun isSatisfiedBy(screening: Screening): Boolean
}