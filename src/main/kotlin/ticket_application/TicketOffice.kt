package ticket_application

class TicketOffice(
    private var amount: Long,
    vararg tickets: Ticket
) {
    private val tickets: MutableList<Ticket> = mutableListOf()

    init {
        this.tickets.addAll(tickets)
    }

    fun getTicket(): Ticket = tickets.removeFirst()

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}