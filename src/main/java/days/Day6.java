package main.java.days;

import main.java.util.InputReader;
public class Day6 {
    private final String inputString = InputReader.getInputAsString(6);

    public int answerPart1() {
        int counter = 0;
        for (int i=4; i<=inputString.length(); i++) {
            counter = i;
            char firstChar = inputString.charAt(i-4);
            char secondChar = inputString.charAt(i-3);
            char thirdChar = inputString.charAt(i-2);
            char fourthChar = inputString.charAt(i-1);
            if (
                firstChar != secondChar &&
                firstChar != thirdChar &&
                firstChar != fourthChar &&
                secondChar != thirdChar &&
                secondChar != fourthChar &&
                thirdChar != fourthChar
            ) {
                break;
            }
        }
        return counter;
    }

    public int answerPart2() {
        int counter = 0;
        for (int i=14; i<=inputString.length(); i++) {
            counter = i;
            boolean found = false;
            int[] alphabet = new int[26];
            for (int j=i-14; j<i; j++) {
                int placeInAlphabet = inputString.charAt(j) - 'a';
                if (alphabet[placeInAlphabet] == 1) {
                    found = false;
                    break;
                } else {
                    alphabet[placeInAlphabet] += 1;
                }
                found = true;
            }
            if (found) break;
        }
        return counter;
    }
}
