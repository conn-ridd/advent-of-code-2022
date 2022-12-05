package main.java.days;

import main.java.util.InputReader;
import java.util.List;

public class Day4 {
    List<String> inputList = InputReader.getInputAsList(4);

    public int answerPart1() {
        int counter = 0;
        for (String section: inputList) {
            String[] splitSections = section.split(",");
            String firstElf = splitSections[0];
            String secondElf = splitSections[1];
            String[] firstSectionsSplit = firstElf.split("-");
            String[] secondSectionsSplit = secondElf.split("-");
            int firstElfSmallerNumber = Integer.parseInt(firstSectionsSplit[0]);
            int firstElfLargerNumber = Integer.parseInt(firstSectionsSplit[1]);
            int secondElfSmallerNumber = Integer.parseInt(secondSectionsSplit[0]);
            int secondElfLargerNumber = Integer.parseInt(secondSectionsSplit[1]);
            if (firstElfSmallerNumber <= secondElfSmallerNumber && firstElfLargerNumber >= secondElfLargerNumber) {
                counter ++;
            } else if (secondElfSmallerNumber <= firstElfSmallerNumber && secondElfLargerNumber >= firstElfLargerNumber) {
                counter ++;
            }
        }
        return counter;
    }

    public int answerPart2() {
        int totalOverdoneSections = 0;
        for (String section: inputList) {
            String[] splitSections = section.split(",");
            String firstElf = splitSections[0];
            String secondElf = splitSections[1];
            String[] firstSectionsSplit = firstElf.split("-");
            String[] secondSectionsSplit = secondElf.split("-");
            int firstElfSmallerNumber = Integer.parseInt(firstSectionsSplit[0]);
            int firstElfLargerNumber = Integer.parseInt(firstSectionsSplit[1]);
            int secondElfSmallerNumber = Integer.parseInt(secondSectionsSplit[0]);
            int secondElfLargerNumber = Integer.parseInt(secondSectionsSplit[1]);
            if (firstElfSmallerNumber <= secondElfSmallerNumber && secondElfLargerNumber <= firstElfLargerNumber) {
                totalOverdoneSections ++;
            } else if (firstElfSmallerNumber <= secondElfSmallerNumber && secondElfSmallerNumber <= firstElfLargerNumber) {
                totalOverdoneSections ++;
            } else if(secondElfSmallerNumber <= firstElfSmallerNumber && firstElfLargerNumber <= secondElfLargerNumber) {
                totalOverdoneSections ++;
            } else if(secondElfSmallerNumber <= firstElfSmallerNumber && firstElfSmallerNumber <= secondElfLargerNumber) {
                totalOverdoneSections ++;
             }
        }
        return totalOverdoneSections;
    }
}
