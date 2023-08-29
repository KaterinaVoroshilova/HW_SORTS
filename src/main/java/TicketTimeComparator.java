import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int ticketTime1 = t1.getTimeTo()-t1.getTimeFrom();
        int ticketTime2 = t2.getTimeTo()-t2.getTimeFrom();
        if (ticketTime1<0){
            ticketTime1 = 24+ticketTime1;
        }
        if (ticketTime2<0){
            ticketTime2 = 24+ticketTime2;
        }
        if (ticketTime1 < ticketTime2) {
            return -1;
        } else if (ticketTime1 > ticketTime2) {
            return 1;
        } else {
            return 0;
        }
    }
}