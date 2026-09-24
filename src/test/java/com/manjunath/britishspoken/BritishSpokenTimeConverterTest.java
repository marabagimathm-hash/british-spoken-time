package com.manjunath.britishspoken;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BritishSpokenTimeConverterTest {

    private final BritishSpokenTimeConverter converter =
            new BritishSpokenTimeConverter();

    @Test
    void shouldConvertHourExactly() {
        assertEquals("one o'clock", converter.convert(1, 0));
    }

    @Test
    void shouldConvertMinutesPast() {
        assertEquals("five past two", converter.convert(2, 5));
        assertEquals("ten past three", converter.convert(3, 10));
        assertEquals("twenty past five", converter.convert(5, 20));
        assertEquals("twenty-five past six", converter.convert(6, 25));
    }

    @Test
    void shouldConvertQuarterPast() {
        assertEquals("quarter past four", converter.convert(4, 15));
    }

    @Test
    void shouldConvertHalfPast() {
        assertEquals("half past seven", converter.convert(7, 30));
    }

    @Test
    void shouldConvertMinutesBetweenHalfPastAndFiveTo() {
        assertEquals("six thirty-two", converter.convert(6, 32));
    }

    @Test
    void shouldConvertMinutesToNextHour() {
        assertEquals("twenty-five to eight", converter.convert(7, 35));
        assertEquals("twenty to nine", converter.convert(8, 40));
    }

    @Test
    void shouldConvertQuarterTo() {
        assertEquals("quarter to ten", converter.convert(9, 45));
    }

    @Test
    void shouldConvertMinutesToNextHourForFiveTo() {
        assertEquals("ten to eleven", converter.convert(10, 50));
        assertEquals("five to twelve", converter.convert(11, 55));
    }

    @Test
    void shouldConvertMidnight() {
        assertEquals("midnight", converter.convert(0, 0));
    }

    @Test
    void shouldConvertNoon() {
        assertEquals("noon", converter.convert(12, 0));
    }
}