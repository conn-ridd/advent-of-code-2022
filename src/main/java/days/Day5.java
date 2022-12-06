package main.java.days;

import main.java.util.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {
    private final List<String> inputList = InputReader.getInputAsList(5);
    private final String[] stacks = {"SMRNWJVT", "BWDJQPCV", "BJFHDRP", "FRPBMND", "HVRPTB", "CBPT", "BJRPL", "NCSLTZBW", "LSG"};
    private final String[] stacks2 = {"SMRNWJVT", "BWDJQPCV", "BJFHDRP", "FRPBMND", "HVRPTB", "CBPT", "BJRPL", "NCSLTZBW", "LSG"};
    public String answerPart1(){
        StringBuilder answer = new StringBuilder();
        for (String command: inputList){
            String[] splitWords = command.split(" ");
            int amountToMove = Integer.parseInt(splitWords[1]);
            int numberMoveFrom = Integer.parseInt(splitWords[3]);
            int numberMoveTo = Integer.parseInt(splitWords[5]);
            for (int i=amountToMove; i>0; i--) {
                String moveFrom = this.stacks[numberMoveFrom-1];
                char charToMove = moveFrom.charAt(moveFrom.length()-1);
                this.stacks[numberMoveTo-1] = this.stacks[numberMoveTo-1] + charToMove;
                this.stacks[numberMoveFrom-1] = moveFrom.substring(0, moveFrom.length()-1);
            }
        }
        for (String stack: this.stacks) {
            answer.append(stack.charAt(stack.length() - 1));
        }
        return answer.toString();
    }

    public String answerPart2(){
        StringBuilder answer = new StringBuilder();
        for (String command: inputList){
            String[] splitWords = command.split(" ");
            int amountToMove = Integer.parseInt(splitWords[1]);
            int numberMoveFrom = Integer.parseInt(splitWords[3]);
            int numberMoveTo = Integer.parseInt(splitWords[5]);
            String cratesBeingMoved = this.stacks2[numberMoveFrom-1].substring(stacks2[numberMoveFrom-1].length()-amountToMove);
            this.stacks2[numberMoveTo-1] = this.stacks2[numberMoveTo-1] + cratesBeingMoved;
            this.stacks2[numberMoveFrom-1] = this.stacks2[numberMoveFrom-1].substring(0, stacks2[numberMoveFrom-1].length()-amountToMove);
        }
        for (String stack: this.stacks2) {
            answer.append(stack.charAt(stack.length() - 1));
        }
        return answer.toString();
    }

}
