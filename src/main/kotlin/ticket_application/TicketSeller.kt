package ticket_application

class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun getTicketOffice(): TicketOffice = ticketOffice
}