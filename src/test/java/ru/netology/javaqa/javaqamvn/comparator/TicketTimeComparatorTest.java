package ru.netology.javaqa.javaqamvn.comparator;

import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTimeComparatorTest {

    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void shouldCompareIfLess() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Warsaw",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Dubai",
                "Perth",
                5_000,
                1000,
                2000
        );

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfMore() {

        Ticket ticket1 = new Ticket(
                "Dubai",
                "Perth",
                5_000,
                1000,
                2000
        );

        Ticket ticket2 = new Ticket(
                "Berlin",
                "Warsaw",
                1_000,
                1000,
                1200
        );

        int expected = 1;
        int actual = comparator.compare(ticket1, ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfEquals() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Warsaw",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Prague",
                "Warsaw",
                2_000,
                1200,
                1400
        );

        int expected = 0;
        int actual = comparator.compare(ticket1, ticket2);
        assertEquals(expected, actual);
    }
}
