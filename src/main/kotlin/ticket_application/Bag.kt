package ticket_application

class Bag(
    private var amount: Long,
    private val invitaion: Invitation?,
    private var ticket: Ticket?
) {
    fun hasInvitaion(): Boolean = invitaion != null
    fun hasTicket(): Boolean = ticket != null

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}