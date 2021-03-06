package com.codecool.input;

import java.util.Scanner;

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
            inputString = inputStringValidation(scanner.nextLine());
        }
        return inputString;
    }

    private String inputStringValidation(String inputString) {
        String checker = inputString.toLowerCase();
        if (checker.contains(";") || checker.contains("'") || checker.contains("--") ||
                checker.contains("/*") || checker.contains("*/") || checker.contains("insert") ||
                checker.contains("xp_") || checker.contains("select") || checker.contains("drop") ||
                checker.contains("delete") || checker.contains("update")) {
            return "";
        }
        return inputString;
    }


}
