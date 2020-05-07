package com.codecool.input;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class InputProvider {

    Scanner scanner = new Scanner(System.in);

    public InputProvider() {

    }

    public int getPositiveNumber(String message) {
        System.out.println(String.format("%s: ", message));
        int number = -1;
        while (number < 0) {
            String input = scanner.nextLine();
            if (properNumberProvided(input)) {
                number = Integer.parseInt(input);
            }
        }
        return number;
    }

    public int getProperActionKey(int actionKeys, String message) {
        System.out.println(String.format("%s: ", message));
        int key = -1;
        while (!( (-1 < key) && (key < actionKeys))) {
            String input = scanner.nextLine();
            if (properNumberProvided(input)) {
                key = Integer.parseInt(input);
            }
        }
        return key;
    }

    private boolean properNumberProvided(String input) {
        if (input.isEmpty()) {
            return false;
        }
        return input.chars().allMatch( Character::isDigit );
    }

    public String getValidateWord(String message) {
        System.out.println(String.format("%s: ", message));
        String inputString = "";
        while (inputString.isEmpty()) {
            inputString = scanner.nextLine();
        }
        char[] input = inputString.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char letter : input) {
            if (Character.isAlphabetic(letter) || Character.isDigit(letter)) {
                builder.append(letter);
            }
        }
        return builder.toString();
    }


}
