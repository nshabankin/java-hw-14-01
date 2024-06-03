package ru.netology.javaqa.javaqamvn.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {

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

    @Test
    public void shouldGetFrom() {
        String expected = "Berlin";
        String actual = ticket1.getFrom();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTo() {
        String expected = "Warsaw";
        String actual = ticket1.getTo();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPrice() {
        int expected = 1_000;
        int actual = ticket1.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTimeFrom() {
        int expected = 1000;
        int actual = ticket1.getTimeFrom();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTimeTo() {
        int expected = 1200;
        int actual = ticket1.getTimeTo();
        assertEquals(expected, actual);
    }


    @Test
    public void shouldComparePriceIfLess() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfMore() {

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
        int actual = ticket1.compareTo(ticket2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldComparePriceIfEquals() {

        Ticket ticket1 = new Ticket(
                "Dubai",
                "Perth",
                1_000,
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


        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        assertEquals(expected, actual);
    }
}
