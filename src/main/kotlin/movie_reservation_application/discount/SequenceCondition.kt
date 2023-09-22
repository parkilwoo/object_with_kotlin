package movie_reservation_application.discount

import movie_reservation_application.Screening

/**
 * 순번 조건을 가진 할인 클래스
 * Sequence를 인스턴스 변수로 포함한다.
 */
class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {
    /**
     * 인자로 전달된 screening의 상영 순번과 일치할 경우 할인이 가능한것으로 판단한다.
     */
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}