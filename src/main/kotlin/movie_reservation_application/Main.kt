package movie_reservation_application

import movie_reservation_application.discount.*
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // 금액 할인 정책이 들어간 영화
            val avatar: Movie = Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                AmountDiscountPolicy(Money.wons(800),
                    SequenceCondition(1),
                    SequenceCondition(10),
                    PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                    PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                    )
            )

            // 비율 할인 정책이 들어간 영화
            val titanic: Movie = Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                PercentDiscountPolicy(0.1,
                    PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                    SequenceCondition(2),
                    PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                    )
            )

            // 할인 정책이 없는 영화
            val starWars: Movie = Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                NoneDiscountPolicy()
            )

            // 실행 시점에서 할인 정책이 변경될 수 있도록 DiscountPolicy 인스턴스를 연결한다.
            avatar.changeDiscountPolicy(
                PercentDiscountPolicy(0.1,
                    PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                    SequenceCondition(2),
                    PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                )
            )
        }
    }
}