package com.manjunath.britishspoken;

public class BritishSpokenTimeConverter {

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
        String[] hours = {
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

        return hours[hour % 12];
    }

    private String numberToWords(int number) {
        String[] ones = {
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

        String[] tens = {
                "",
                "",
                "twenty",
                "thirty",
                "forty",
                "fifty"
        };

        if (number < 20) {
            return ones[number];
        }

        int tensPart = number / 10;
        int onesPart = number % 10;

        if (onesPart == 0) {
            return tens[tensPart];
        }

        return tens[tensPart] + "-" + ones[onesPart];
    }
}