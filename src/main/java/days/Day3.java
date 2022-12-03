package main.java.days;

import main.java.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day3 {
    private final List<String> inputList = InputReader.getInputAsList(3);
    public int answerPart1() {
        List<Character> commonCharacters = new ArrayList<>();
        for (String contents: inputList) {
            String secondCompartment = contents.substring(contents.length()/2);
            for (int i=0; i < contents.length() / 2; i++) {
                if (secondCompartment.contains(String.valueOf(contents.charAt(i)))) {
                    commonCharacters.add(contents.charAt(i));
                    break;
                }
            }
        }
        return calculateTotal(commonCharacters);
    }
    public int calculateTotal(List<Character> commonCharacters) {
        int total = 0;
        for (char character: commonCharacters) {
            if (0 <= character - 'a') total += character - 'a' + 1;
            else total += character - 'A' + 27;
        }
        return total;
    }

    public int answerPart2() {
        List<Character> commonCharacters = new ArrayList<>();
        for (int i=0; i<inputList.size(); i+=3) {
            char badge = 0;
            String sack1 = inputList.get(i);
            String sack2 = inputList.get(i+1);
            String sack3 = inputList.get(i+2);
            for (char character: sack1.toCharArray()) {
                if (sack2.contains(String.valueOf(character)) && sack3.contains(String.valueOf(character))) {
                    badge = character;
                }
            }
            commonCharacters.add(badge);
            System.out.println(commonCharacters);
        }
        return calculateTotal(commonCharacters);
    }
}

