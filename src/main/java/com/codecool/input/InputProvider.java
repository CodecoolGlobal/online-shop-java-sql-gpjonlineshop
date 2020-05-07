package com.codecool.input;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class InputProvider {

    Scanner scanner = new Scanner(System.in);

    public InputProvider() {

    }

    public int getProperActionKey(int actionKeys) {
        int key = -1;
        while (!( (-1 < key) && (key < actionKeys))) {
            String input = scanner.nextLine();
            if (input.chars().allMatch( Character::isDigit )) {
                key = Integer.parseInt(input);
            }
        }
        return key;
    }

    public String getValidateWord() {
        char[] input = scanner.nextLine().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char letter : input) {
            if (Character.isAlphabetic(letter) || Character.isDigit(letter)) {
                builder.append(letter);
            }
        }
        return builder.toString();
    }


}
