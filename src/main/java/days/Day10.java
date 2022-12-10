package main.java.days;

import main.java.util.InputReader;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Day10 {
    private final List<String> inputList = InputReader.getInputAsList(10);

    public int answerPart1() {
        int X = 1;
        int sum = 0;
        List<Integer> XValueDuringEachCycle = new ArrayList<>();
        for (String command: inputList) {
            if (command.equals("noop")) {
                XValueDuringEachCycle.add(X);
            } else {
                int V = Integer.parseInt(command.split(" ")[1]);
                XValueDuringEachCycle.add(X);
                XValueDuringEachCycle.add(X);
                X += V;
            }
        }
        for (int i=20; i<=220; i += 40) {
            sum += i * XValueDuringEachCycle.get(i - 1);
        }
        return sum;
    }

    public void answerPart2() {
        System.out.println("The answer for day 10 part 2 is:");
        int X = 1;
        List<Integer> XValueDuringEachCycle = new ArrayList<>();
        for (String command: inputList) {
            if (command.equals("noop")) {
                XValueDuringEachCycle.add(X);
            } else {
                int V = Integer.parseInt(command.split(" ")[1]);
                XValueDuringEachCycle.add(X);
                XValueDuringEachCycle.add(X);
                X += V;
            }
        }
        for (int i=0; i<6; i++) {
            StringBuilder outPut = new StringBuilder();
            int CRTCounter = 0;
            for (int j=i*40; j<(i+1)*40; j++) {
                int spriteCentre = XValueDuringEachCycle.get(j);
                if (Math.abs(spriteCentre - CRTCounter) <= 1) {
                    outPut.append("#");
                } else {
                    outPut.append(".");
                }
                CRTCounter ++;
            }
            System.out.println(outPut);
        }
        System.out.println("This reads: PLULKBZH");
    }
}
