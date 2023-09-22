package movie_reservation_application

import java.time.LocalDateTime

/**
 * Screening 클래스는 사용자들이 예매하는 대상인 '상영'을 구현한다.
 */
class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    /**
     * 상영 시작 시간을 반환하는 함수
     */
    fun getStartTime(): LocalDateTime {
        return whenScreened
    }

    /**
     * 순번의 일치 여부를 검사하는 함수
     */
    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    /**
     * 기본 요금을 반환하는 함수
     */
    fun getMovieFee(): Money {
        return movie.getFee()
    }

    private fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }
}