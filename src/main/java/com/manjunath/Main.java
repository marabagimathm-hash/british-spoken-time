package com.manjunath;

import com.manjunath.britishspoken.BritishSpokenTimeConverter;
import com.manjunath.britishspoken.TimeInputParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TimeInputParser parser = new TimeInputParser();
        BritishSpokenTimeConverter converter = new BritishSpokenTimeConverter();

        while (true) {
            System.out.print("Enter time (HH:mm): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                TimeInputParser.TimeInput time = parser.parse(input);
                String result = converter.convert(time.hour(), time.minute());

                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid time: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}