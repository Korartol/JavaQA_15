import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ManagerTicketsTest {
    TicketsRepository repo = new TicketsRepository();
    ManagerTickets manager = new ManagerTickets(repo);

    Tickets ticket1 = new Tickets(1, 1000, "DDE", "ATT", 1);
    Tickets ticket2 = new Tickets(2, 2000, "SVO", "AAA", 2);
    Tickets ticket3 = new Tickets(3, 3000, "DME", "AAA", 3);
    Tickets ticket4 = new Tickets(4, 40000, "DME", "AAA", 4);
    Tickets ticket5 = new Tickets(5, 5000, "DME", "AAA", 5);
    Tickets ticket6 = new Tickets(6, 6000, "DME", "AAA", 6);
    Tickets ticket7 = new Tickets(7, 9000, "DME", "AXZ", 7);
    Tickets ticket8 = new Tickets(8, 8000, "DME", "AXZ", 8);
    Tickets ticket9 = new Tickets(9, 9000, "DME", "AAA", 9);
    Tickets ticket10 = new Tickets(10, 900, "DDE", "ATT", 10);


    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Tickets[] tickets = manager.getTicket();  // сортируем все тесты
        Arrays.sort(tickets);
    }


    @Test
    public void shouldAllTicketsSortFindAll() {
        Tickets[] expected = {ticket2};
        Tickets[] actual = manager.findAll("SVO", "AAA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllTicketsSortFindAll2() {
        Tickets[] expected = {ticket8, ticket7};
        Tickets[] actual = manager.findAll("DME", "AXZ");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAllTicketsSort() {
        Tickets[] expected = {ticket10, ticket1, ticket2, ticket3, ticket5, ticket6, ticket8, ticket7, ticket9, ticket4};
        Tickets[] actual = manager.getTicket();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAllTicketsSortRemoveById() {
        repo.removeById(10);  // удаляем элемент с id 10

        Tickets[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6, ticket8, ticket7, ticket9, ticket4};
        Tickets[] actual = manager.getTicket();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketDeparture() {
        Tickets[] expected = {ticket2};
        Tickets[] actual = manager.searchBy("SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketArrival() {
        Tickets[] expected = {ticket8, ticket7};
        Tickets[] actual = manager.searchBy("AXZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketDepartureAll() {
        Tickets[] expected = {ticket10, ticket1};
        Tickets[] actual = manager.searchBy("DDE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketNotFound() {
        Tickets[] expected = {};
        Tickets[] actual = manager.searchBy("ARK");

        Assertions.assertArrayEquals(expected, actual);
    }
}
