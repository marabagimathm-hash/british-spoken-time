package com.manjunath.britishspoken;

public class TimeInputParser {

    public TimeInput parse(String input) {
        if (input == null || !input.matches("\\d{1,2}:\\d{2}")) {
            throw new IllegalArgumentException("Time must be in H:mm or HH:mm format");
        }

        String[] parts = input.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        if (minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }

        return new TimeInput(hour, minute);
    }

    public record TimeInput(int hour, int minute) {
    }
}