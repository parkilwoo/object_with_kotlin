package movie_reservation_application

import java.math.BigDecimal

/**
 * 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현한다.
 * -> 단순히 Long 타입의 변수로 값을 더하고 빼는것보다 Money 객체로 상태를 변경하는것이 설계의 명확성과 유연성을 높일 수 있다.
 */
class Money(
    private val amount: BigDecimal
) {
    companion object {
        val ZERO: Money = Money.wons(0)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }

    fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    fun times(percent: Double): Money {
        return Money(this.amount.multiply(
            BigDecimal.valueOf(percent)
        ))
    }

    fun isLessThen(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }

}