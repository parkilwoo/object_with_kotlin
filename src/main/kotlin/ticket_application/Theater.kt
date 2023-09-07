package ticket_application

class Theater(
    private val ticketSeller: TicketSeller
){
    fun enter(audience: Audience) {
//        val ticket:Ticket = ticketSeller.getTicketOffice().getTicket()
//        if(!audience.getBag().hasInvitaion()) {
//            audience.getBag().minusAmount(ticket.getFee())
//            ticketSeller.getTicketOffice().plusAmount(ticket.getFee())
//        }
//        audience.getBag().setTicket(ticket)
        /**
         * enter 메서드를 구현했던 코드를 ticketSeller에 위임하면서 더이상 ticketOffice에 접근을 하지 않는다.
         * ticketOffice가 ticketSeller안에 있는지 조차 알 수 없다(은닉화)
         */
        ticketSeller.sellTo(audience)
    }
}