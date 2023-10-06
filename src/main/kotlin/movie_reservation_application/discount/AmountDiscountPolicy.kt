package movie_reservation_application.discount

import movie_reservation_application.Money
import movie_reservation_application.Screening

class AmountDiscountPolicy(

) : DiscountPolicy {
    constructor()
    override fun getDiscountAmount(screening: Screening): Money {
        TODO("Not yet implemented")
    }
}