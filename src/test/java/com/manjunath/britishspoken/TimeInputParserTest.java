package com.manjunath.britishspoken;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeInputParserTest {

    private final TimeInputParser parser = new TimeInputParser();

    @Test
    void shouldParseValidTime() {
        TimeInputParser.TimeInput result = parser.parse("2:45");

        assertEquals(2, result.hour());
        assertEquals(45, result.minute());
    }

    @Test
    void shouldRejectInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("1:5"));
        assertThrows(IllegalArgumentException.class, () -> parser.parse("01:5"));
        assertThrows(IllegalArgumentException.class, () -> parser.parse("0145"));
    }

    @Test
    void shouldRejectInvalidHour() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("24:00"));
    }

    @Test
    void shouldRejectInvalidMinute() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("12:60"));
    }
}