package com.manjunath.britishspoken;

public class BritishSpokenTimeConverter {

    private static final String[] HOURS = {
            "twelve",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven"
    };

    private static final String[] ONES = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] TENS = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty"
    };

    public String convert(int hour, int minute) {
        validateTime(hour, minute);

        if (hour == 0 && minute == 0) {
            return "midnight";
        }

        if (hour == 12 && minute == 0) {
            return "noon";
        }

        if (minute == 0) {
            return hourToWords(hour) + " o'clock";
        }

        if (minute < 15) {
            return numberToWords(minute) + " past " + hourToWords(hour);
        }

        if (minute == 15) {
            return "quarter past " + hourToWords(hour);
        }

        if (minute < 30) {
            return numberToWords(minute) + " past " + hourToWords(hour);
        }

        if (minute == 30) {
            return "half past " + hourToWords(hour);
        }

        if (minute < 35) {
            return hourToWords(hour) + " " + numberToWords(minute);
        }

        int nextHour = (hour + 1) % 24;
        int minutesToNextHour = 60 - minute;

        if (minute == 45) {
            return "quarter to " + hourToWords(nextHour);
        }

        return numberToWords(minutesToNextHour) + " to " + hourToWords(nextHour);
    }

    private void validateTime(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
    }

    private String hourToWords(int hour) {
        return HOURS[hour % 12];
    }

    private String numberToWords(int number) {
        if (number < 20) {
            return ONES[number];
        }

        int tensPart = number / 10;
        int onesPart = number % 10;

        if (onesPart == 0) {
            return TENS[tensPart];
        }

        return TENS[tensPart] + "-" + ONES[onesPart];
    }
}