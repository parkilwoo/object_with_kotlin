package ticket_application

class Ticket(private val fee: Long) {
    fun getFee(): Long = fee
}