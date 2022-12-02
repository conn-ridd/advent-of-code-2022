package main.java.days;

import main.java.util.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    private final List<String> inputList;

    private final List<Integer> ignoreList = new ArrayList<>();
    public Day1() {
        this.inputList = InputReader.getInputAsList(1);
    }
    public int highestCalorieElf() {
        int highestCalories = 0;
        int currentElfCalories = 0;

        for (String number: inputList) {
            if (!number.equals("")) {
                currentElfCalories += Long.parseLong(number);
            } else if(currentElfCalories > highestCalories) {
                highestCalories = currentElfCalories;
                currentElfCalories = 0;
            } else currentElfCalories = 0;
        }
        if(currentElfCalories > highestCalories) {
            highestCalories = currentElfCalories;
        }
        return highestCalories;
    }

    public int highestCalorieElfIgnoring() {
        int highestElf = 1;
        int highestCalories = 0;
        int currentElfCalories = 0;
        int currentElf = 1;

        for (String number: inputList) {
            if (!number.equals("")) {
                currentElfCalories += Long.parseLong(number);
            } else if(currentElfCalories > highestCalories && !this.ignoreList.contains(currentElf)) {
                highestCalories = currentElfCalories;
                highestElf = currentElf;
                currentElf ++;
                currentElfCalories = 0;
            } else {
                currentElf ++;
                currentElfCalories = 0;
            }
        }
        if(currentElfCalories > highestCalories && !this.ignoreList.contains(currentElf)) {
            highestCalories = currentElfCalories;
            highestElf = currentElf;
        }
        this.ignoreList.add(highestElf);
        return highestCalories;
    }

    public int sumOf3HighestElves() {
        return highestCalorieElfIgnoring() + highestCalorieElfIgnoring() + highestCalorieElfIgnoring();
    }
}
