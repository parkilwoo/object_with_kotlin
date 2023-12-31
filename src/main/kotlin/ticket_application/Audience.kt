package ticket_application

class Audience(private val bag: Bag) {
//    fun getBag(): Bag = bag

    /**
     * Audience가 직접 가방안에 초대장이 들어있는지 확인을 한다.
     * 외부에서는 더이상 Audience가 bag을 소유하고 있는지 확인할 필요가 없으므로 getBag 메서드를 삭제한다. (캡슐화)
     */
//    fun buy(ticket: Ticket): Long {
//        if(bag.hasInvitaion()) {
//            bag.setTicket(ticket)
//            return 0L
//        }
//
//        bag.setTicket(ticket)
//        bag.minusAmount(ticket.getFee())
//        return ticket.getFee()
//    }
    /**
     * Bag Refactoring
     * Bag의 구현을 캡슐화 하였으므로 Audience객체는 Bag의 구현이 아닌 인터페이스에만 의존하도록 수정한다.
     */
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}