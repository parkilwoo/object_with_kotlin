package ticket_application

class Bag(
    private var amount: Long,
    private val invitaion: Invitation?,
    private var ticket: Ticket?
) {
    /**
     * Bag Refactoring
     * Bag의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화 해서 결합도를 낮춘다.
     * hasTicket(), plusAmount() Method 삭제
     * hasInvitaion(), minusAmount(), setTicket() Method를 더이상 외부에서 사용하지 않으므로 private로 변경
     */
    fun hold(ticket: Ticket): Long {
        return if (hasInvitaion()) {
            setTicket(ticket)
            0L
        } else {
            setTicket(ticket)
            minusAmount(ticket.getFee())
            ticket.getFee()
        }
    }
    private fun hasInvitaion(): Boolean = invitaion != null
//    fun hasTicket(): Boolean = ticket != null
    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

//    fun plusAmount(amount: Long) {
//        this.amount += amount
//    }
}