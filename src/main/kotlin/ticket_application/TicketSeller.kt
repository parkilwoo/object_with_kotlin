package ticket_application

class TicketSeller(
    private val ticketOffice: TicketOffice
) {

    /**
     * Theater의 enter 메서드에서 TicketOffice에 접근하는 모든 코드를 TicketSeller에 sellTo로 이관하면서 객체의 자율성을 높이자
     * 또한, getTicketOffice 메서드를 삭제하면서 외부에서는 더이상 ticketOffice에 접근하는 방법이 없다(캡슐화)
     */
    fun sellTo(audience: Audience) {
//        val ticket:Ticket = ticketOffice.getTicket()
//        if(!audience.getBag().hasInvitaion()) {
//            audience.getBag().minusAmount(ticket.getFee())
//            ticketOffice.plusAmount(ticket.getFee())
//        }
//        audience.getBag().setTicket(ticket)
        /**
         * TicketSeller는 더이상 Audience의 bag에 관심을 둘 필요가 없다. 따라서 Audience의 인터페이스에만 의존할 수 있도록 한다.
         */
//        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
        /**
         * TicketSeller가 TicketOffice에 마음대로 드나들며 티켓을 판매하는 행위를 금지
         * TickerOffice에 티켓판매에 대한 자율과 책임을 주어 TicketOffice의 구현이 아닌 인터페이스에만 의존하게 변경.
         */
        ticketOffice.sellTicketTo(audience)
    }
}