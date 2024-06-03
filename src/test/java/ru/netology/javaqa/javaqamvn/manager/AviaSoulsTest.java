package ru.netology.javaqa.javaqamvn.manager;

import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.comparator.TicketTimeComparator;
import ru.netology.javaqa.javaqamvn.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void shouldFindAll() {

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

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = aviaSouls.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByPrice() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Warsaw",
                5_000,
                1900,
                2100
        );

        Ticket ticket2 = new Ticket(
                "Berlin",
                "Warsaw",
                1_000,
                900,
                1300
        );

        Ticket ticket3 = new Ticket(
                "Berlin",
                "Warsaw",
                3_000,
                500,
                1200
        );

        Ticket ticket4 = new Ticket(
                "Berlin",
                "Warsaw",
                2_000,
                2000,
                2300
        );

        Ticket ticket5 = new Ticket(
                "Berlin",
                "Warsaw",
                4_000,
                1100,
                1300
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket2, ticket4, ticket3, ticket5, ticket1};
        Ticket[] actual = aviaSouls.search("Berlin", "Warsaw");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnIfOnlyOneTicketFound() {

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

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.search("Berlin", "Warsaw");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfOnlyFrom() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Dubai",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Berlin",
                "Perth",
                5_000,
                1000,
                2000
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Berlin", "Warsaw");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfOnlyTo() {

        Ticket ticket1 = new Ticket(
                "Dubai",
                "Warsaw",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Prague",
                "Warsaw",
                5_000,
                1000,
                2000
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Berlin", "Warsaw");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoTicketFound() {

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

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "St. Petersburg");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByTime() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Warsaw",
                1_000,
                1200,
                1600
        );

        Ticket ticket2 = new Ticket(
                "Berlin",
                "Warsaw",
                2_000,
                1000,
                1200
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Berlin", "Warsaw", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByTimeIfOnlyOneTicketFound() {

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

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Berlin", "Warsaw", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByTimeEmptyIfOnlyFrom() {

        Ticket ticket1 = new Ticket(
                "Berlin",
                "Dubai",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Berlin",
                "Perth",
                5_000,
                1000,
                2000
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Berlin", "Warsaw", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByTimeEmptyIfOnlyTo() {

        Ticket ticket1 = new Ticket(
                "Dubai",
                "Warsaw",
                1_000,
                1000,
                1200
        );

        Ticket ticket2 = new Ticket(
                "Prague",
                "Warsaw",
                5_000,
                1000,
                2000
        );

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Berlin", "Warsaw", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnSortedByTimeEmptyIfNoTicketFound() {

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

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "St. Petersburg", comparator);
        assertArrayEquals(expected, actual);
    }
}
