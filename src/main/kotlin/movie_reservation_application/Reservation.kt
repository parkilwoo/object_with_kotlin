package movie_reservation_application

/**
 * 영화 예매 Class
 * 예매하기위해 Screening, Movie, Reservation 인스턴스들은 서로의 메서드를 호출하며 상호 작용한다.
 */
class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
)