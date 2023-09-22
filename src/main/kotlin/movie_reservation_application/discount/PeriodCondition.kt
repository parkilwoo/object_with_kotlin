package movie_reservation_application.discount

import movie_reservation_application.Screening
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * 기간에 조건을 가진 할인 클래스
 * 조건에 사용할 요일, 시작시간, 종료시간을 인스턴스 변수로 포함한다.
 */
class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {
    /**
     * screenin의 상영 요일이 dayOfWeek와 같고 상영 시작 시간이 startTime과 endTime 사이에 있을경우 true를 반환한다.
     */
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.getStartTime().dayOfWeek.equals(dayOfWeek) &&
                startTime <= screening.getStartTime().toLocalTime() &&
                endTime >= screening.getStartTime().toLocalTime()
    }
}