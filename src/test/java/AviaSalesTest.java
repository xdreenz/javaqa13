import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AviaSalesTest {
    AviaSales aviaSales = new AviaSales();
    TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("BQD", "VZR", 14500, 1120, 1210);
    Ticket ticket2 = new Ticket("RSQ", "ALC", 25500, 1420, 1640); //220
    Ticket ticket3 = new Ticket("EGW", "MGF", 11900, 850, 1430);
    Ticket ticket4 = new Ticket("RSQ", "ALC", 19800, 730, 1040); //310
    Ticket ticket5 = new Ticket("RSQ", "ALC", 31200, 1610, 1800); //190

    @BeforeEach
    void setUp() {
        aviaSales.add(ticket1);
        aviaSales.add(ticket2);
        aviaSales.add(ticket3);
        aviaSales.add(ticket4);
        aviaSales.add(ticket5);
    }
    @Test
    void shouldFindAll() {
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSales.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearch() {
        Ticket[] expected = new Ticket[]{ticket4, ticket2, ticket5};    //ASC-сортировка по цене билета
        Ticket[] actual = aviaSales.search("RSQ", "ALC");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchAndSortBy() {
        Ticket[] expected = new Ticket[]{ticket5, ticket2, ticket4};    //ASC-сортировка по времени перелёта
        Ticket[] actual = aviaSales.searchAndSortBy("RSQ", "ALC", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}