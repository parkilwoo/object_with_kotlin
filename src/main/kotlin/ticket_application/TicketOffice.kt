package ticket_application

class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private val tickets: MutableList<Ticket> = mutableListOf()

    init {
        this.tickets.addAll(tickets)
    }

    /**
     * TickerOffice Refactoring
     * TicketOffice에서 티켓을 판매하는 sellTicketTo Method를 만들어 티켓 판매에 대한 책임 부여
     * Ticket 판매에 필요한 getTicket(), plusAmount() Method는 TicketOffice 내부에서만 필요하므로 private
     * 하지만 이 작업으로 인해 Audience와의 의존성이 생김
     * -> 완벽한 설계는 있을 수 없으므로 만족스러운 트레이드 오프를 고려해야함;
     */

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }
    private fun getTicket(): Ticket = tickets.removeFirst()

//    fun minusAmount(amount: Long) {
//        this.amount -= amount
//    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}