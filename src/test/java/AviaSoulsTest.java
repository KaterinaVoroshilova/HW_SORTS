import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Внуково", "Пулково", 5000, 18, 19);
    Ticket ticket2 = new Ticket("Внуково", "Пулково", 3000, 11, 13);

    Ticket ticket3 = new Ticket("Внуково", "Пулково", 6500, 13, 14);
    Ticket ticket4 = new Ticket("Внуково", "Пулково", 5000, 23, 1);
    Ticket ticket5 = new Ticket("Внуково", "Пулково", 2500, 12, 15);
    Ticket ticket6 = new Ticket("Внуково", "Сыктывкар", 6500, 12, 16);

    @Test
    public void compareToTestFirstBigger(){
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestFirstLetter(){
        int expected = -1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestEqual(){
        int expected = 0;
        int actual = ticket1.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTest(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4, ticket3};
        Ticket[] actual = tickets.search("Внуково", "Пулково");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestNull(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.search("Внуково", "Нижний Новгород");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestOne(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        Ticket[] expected = {ticket6};
        Ticket[] actual = tickets.search("Внуково", "Сыктывкар");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTimeComparatorTest(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Arrays.sort(tickets.findAll(), timeComparator);

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBy(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();


        Ticket[] expected = {ticket1, ticket3, ticket2, ticket4, ticket5};
        Ticket[] actual = tickets.searchAndSortBy("Внуково", "Пулково", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByNull(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();


        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.searchAndSortBy("Внуково", "Нижний Новгород", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByOne(){
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();


        Ticket[] expected = {ticket6};
        Ticket[] actual = tickets.searchAndSortBy("Внуково", "Сыктывкар", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
