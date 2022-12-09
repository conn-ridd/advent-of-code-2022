package main.java.days;

import main.java.util.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
    private final List<String> inputList = InputReader.getInputAsList(9);
    private int headX = 0;
    private int headY = 0;
    private int[] tailPosition = new int[2];
    private int[][] knotPositions = new int[10][2];

    private List<String> visitedPositions = new ArrayList<>();

    public int answerPart1() {
        List<String> visitedPositions = new ArrayList<>();
        visitedPositions.add("(0,0)");

        for (String movement: inputList) {
            int amountToMove = Integer.parseInt(movement.substring(2));
            if (movement.charAt(0) == 'R') {
                for (int i=1; i<=amountToMove; i++) {
                    headX ++;
                    tailPosition = updateTailPosition(tailPosition, headX, headY);
                    String tailPositionString = "(" + tailPosition[0] + "," + tailPosition[1] + ")";
                    if (!visitedPositions.contains(tailPositionString)) {
                        visitedPositions.add(tailPositionString);
                    }
                }
            } else if (movement.charAt(0) == 'L') {
                for (int i=1; i<=amountToMove; i++) {
                    headX --;
                    tailPosition = updateTailPosition(tailPosition, headX, headY);
                    String tailPositionString = "(" + tailPosition[0] + "," + tailPosition[1] + ")";
                    if (!visitedPositions.contains(tailPositionString)) {
                        visitedPositions.add(tailPositionString);
                    }
                }
            } else if (movement.charAt(0) == 'U') {
                for (int i=1; i<=amountToMove; i++) {
                    headY ++;
                    tailPosition = updateTailPosition(tailPosition, headX, headY);
                    String tailPositionString = "(" + tailPosition[0] + "," + tailPosition[1] + ")";
                    if (!visitedPositions.contains(tailPositionString)) {
                        visitedPositions.add(tailPositionString);
                    }
                }
            } else {
                for (int i=1; i<=amountToMove; i++) {
                    headY --;
                    tailPosition = updateTailPosition(tailPosition, headX, headY);
                    String tailPositionString = "(" + tailPosition[0] + "," + tailPosition[1] + ")";
                    if (!visitedPositions.contains(tailPositionString)) {
                        visitedPositions.add(tailPositionString);
                    }
                }
            }
        }
        return visitedPositions.size();
    }

    public int[] updateTailPosition(int[] currentTailPosition, int headX, int headY) {
        // head too far right then too far left then too high then too low
        if (currentTailPosition[0] - headX < -1) {
            currentTailPosition[0] = headX-1;
            currentTailPosition[1] = headY;
        } else if (currentTailPosition[0] - headX > 1) {
            currentTailPosition[0] = headX+1;
            currentTailPosition[1] = headY;
        } else if (currentTailPosition[1] - headY < -1) {
            currentTailPosition[0] = headX;
            currentTailPosition[1] = headY-1;
        } else if (currentTailPosition[1] - headY > 1) {
            currentTailPosition[0] = headX;
            currentTailPosition[1] = headY+1;
        }
        return currentTailPosition;
    }

    public int answerPart2() {
        this.visitedPositions = new ArrayList<>();
        this.visitedPositions.add("(0,0)");
        for (String movement: inputList) {
            int amountToMove = Integer.parseInt(movement.substring(2));
            if (movement.charAt(0) == 'R') {
                for (int i=1; i<=amountToMove; i++) {
                    this.knotPositions[0][0] ++;
                    this.knotPositions = updateKnots(knotPositions);
                }
            } else if (movement.charAt(0) == 'L') {
                for (int i=1; i<=amountToMove; i++) {
                    this.knotPositions[0][0] --;
                    this.knotPositions = updateKnots(knotPositions);
                }
            } else if (movement.charAt(0) == 'U') {
                for (int i=1; i<=amountToMove; i++) {
                    this.knotPositions[0][1] ++;
                    this.knotPositions = updateKnots(knotPositions);
                }
            } else {
                for (int i=1; i<=amountToMove; i++) {
                    this.knotPositions[0][1] --;
                    this.knotPositions = updateKnots(knotPositions);
                }
            }
        }
        return this.visitedPositions.size();
    }

    public int[][] updateKnots(int[][] currentKnotPositions) {
        for (int i = 1; i< currentKnotPositions.length; i++) {
            if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] < -1 && currentKnotPositions[i][1] - currentKnotPositions[i-1][1] < -1) {
                currentKnotPositions[i][0] ++;
                currentKnotPositions[i][1] ++;
            } else if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] < -1 && currentKnotPositions[i][1] - currentKnotPositions[i-1][1] > 1) {
                currentKnotPositions[i][0] ++;
                currentKnotPositions[i][1] --;
            } else if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] > 1 && currentKnotPositions[i][1] - currentKnotPositions[i-1][1] > 1) {
                currentKnotPositions[i][0] --;
                currentKnotPositions[i][1] --;
            } else if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] > 1 && currentKnotPositions[i][1] - currentKnotPositions[i-1][1] < -1) {
                currentKnotPositions[i][0] --;
                currentKnotPositions[i][1] ++;
            } else if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] < -1) {
                currentKnotPositions[i][0] = currentKnotPositions[i-1][0]-1;
                currentKnotPositions[i][1] = currentKnotPositions[i-1][1];
            } else if (currentKnotPositions[i][0] - currentKnotPositions[i-1][0] > 1) {
                currentKnotPositions[i][0] = currentKnotPositions[i-1][0]+1;
                currentKnotPositions[i][1] = currentKnotPositions[i-1][1];
            } else if (currentKnotPositions[i][1] - currentKnotPositions[i-1][1] < -1) {
                currentKnotPositions[i][0] = currentKnotPositions[i-1][0];
                currentKnotPositions[i][1] = currentKnotPositions[i-1][1]-1;
            } else if (currentKnotPositions[i][1] - currentKnotPositions[i-1][1] > 1) {
                currentKnotPositions[i][0] = currentKnotPositions[i-1][0];
                currentKnotPositions[i][1] = currentKnotPositions[i-1][1]+1;
            }
        }
        String tailPositionString = "(" + currentKnotPositions[currentKnotPositions.length-1][0] + "," + currentKnotPositions[currentKnotPositions.length-1][1] + ")";
        if (!this.visitedPositions.contains(tailPositionString)) {
            this.visitedPositions.add(tailPositionString);
        }
        return currentKnotPositions;
    }

}
