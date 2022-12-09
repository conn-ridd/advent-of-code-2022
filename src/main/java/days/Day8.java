package main.java.days;

import main.java.util.InputReader;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Day8 {
    private final List<String> inputList = InputReader.getInputAsList(8);

    private final int[] highestInRow = new int[inputList.size()];

    private final int[] columnOfHighestInRow = new int[inputList.size()];
    private final int[] highestInColumn = new int[inputList.get(0).length()];

    private final int[] rowOfHighestInColumn = new int[inputList.get(0).length()];

    public int answerPart1() {
        findHighest();
        return checkIfVisible();
    }

    public int checkIfVisible() {
        int counterForRow = 0;
        int visibleTrees = 0;
        for (String trees: inputList) {
            for (char tree: trees.toCharArray()) {
                int treeInteger = tree - '0';
                int treeColumn = trees.indexOf(tree);
                if (trees.indexOf(tree) == 0 || trees.indexOf(tree) == trees.length()-1 || counterForRow == 0 || counterForRow == inputList.size()-1) {
                    visibleTrees ++;
                } else if (treeInteger == highestInColumn[treeColumn] && treeInteger == highestInRow[counterForRow] && counterForRow == rowOfHighestInColumn[treeColumn] && treeColumn == columnOfHighestInRow[counterForRow]) {
                    visibleTrees ++;
                }
            }
            counterForRow ++;
        }
        return visibleTrees;
    }

    public void findHighest() {
        int counterForRow = 0;
        for (String trees: inputList) {
            for (char tree: trees.toCharArray()) {
                int treeInteger = tree - '0';
                if (treeInteger > highestInRow[counterForRow]) {
                    this.highestInRow[counterForRow] = treeInteger;
                    this.columnOfHighestInRow[counterForRow] = trees.indexOf(tree);
                }
                if (treeInteger == highestInRow[counterForRow]) {
                    this.columnOfHighestInRow[counterForRow] = -1;
                }
                if (treeInteger > highestInColumn[trees.indexOf(tree)]) {
                    this.highestInColumn[trees.indexOf(tree)] = treeInteger;
                    this.rowOfHighestInColumn[trees.indexOf(tree)] = counterForRow;
                }
                if (treeInteger == highestInColumn[trees.indexOf(tree)]) {
                    this.rowOfHighestInColumn[trees.indexOf(tree)] = -1;
                }
            }
            counterForRow ++;
        }
    }


    public int betterAnswer() {
        int totalVisible = 0;
        for (int j=0; j<inputList.size(); j++) {
            String rowOfTrees = inputList.get(j);
            if (j == 0 || j == inputList.size()-1) {
                totalVisible += rowOfTrees.length();
            } else {
                for (int k=0; k<rowOfTrees.length(); k++) {
                    char tree = rowOfTrees.charAt(k);
//                    System.out.println(Arrays.toString(rowOfTrees.toCharArray()));
                    if (k == 0 || k == rowOfTrees.length()-1) {
                        totalVisible ++;
//                        System.out.println("tree of height " + tree + " has been ignored because it's on the edge of the grid");
                    } else {
                        int treeHeight = tree - '0';
                        boolean isVisibleFromLeft = true;
                        boolean isVisibleFromRight = true;
                        boolean isVisibleFromAbove = true;
                        boolean isVisibleFromBelow = true;
                        // check visible in row
                        for (int i=0; i<rowOfTrees.length(); i++) {
                            int otherTreeHeight = rowOfTrees.charAt(i) - '0';
                            if (i < k && (treeHeight < otherTreeHeight || treeHeight == otherTreeHeight)) {
                                isVisibleFromLeft = false;
                            } else if (i > k && (treeHeight < otherTreeHeight || treeHeight == otherTreeHeight)) {
                                isVisibleFromRight = false;
                            }
                        }
                        // check visible from above or below
                        for (int x=0; x<inputList.size(); x++) {
                            String otherRowOfTrees = inputList.get(x);
                            if (j != x) {
                                char otherTree = otherRowOfTrees.charAt(k);
                                int otherTreeHeight = otherTree - '0';
                                // check above then check below
                                if (j > x && treeHeight <= otherTreeHeight) {
                                    isVisibleFromAbove = false;
                                } else if (treeHeight <= otherTreeHeight) {
                                    isVisibleFromBelow = false;
                                }
                            }
                        }
                        if (isVisibleFromAbove || isVisibleFromBelow || isVisibleFromLeft || isVisibleFromRight) {
                            totalVisible ++;
                        }
                    }
                }
            }
        }
        return totalVisible;
    }

    public int betterAnswerPart2() {
        int bestScenicValue = 0;
        for (int j=1; j<inputList.size()-1; j++) {
            String rowOfTrees = inputList.get(j);
            for (int k=1; k<rowOfTrees.length()-1; k++) {
                char tree = rowOfTrees.charAt(k);
//              System.out.println(Arrays.toString(rowOfTrees.toCharArray()));
                int treeHeight = tree - '0';
                boolean alreadyCheckedRight = false;
                boolean alreadyCheckedBelow = false;
                int leftVision = k;
                int rightVision = rowOfTrees.length() - k - 1;
                int aboveVision = j;
                int belowVision = inputList.size() - j - 1;
                // check visible in row
                for (int i=0; i<rowOfTrees.length(); i++) {
                    int otherTreeHeight = rowOfTrees.charAt(i) - '0';
                    if (i < k && (treeHeight < otherTreeHeight || treeHeight == otherTreeHeight)) {
                        leftVision = k - i;
                    } else if (i > k && (treeHeight < otherTreeHeight || treeHeight == otherTreeHeight)) {
                        if (!alreadyCheckedRight) {
                            rightVision = i - k;
                            alreadyCheckedRight = true;
                        }
                    }
                }
                // check visible from above or below
                for (int x=0; x<inputList.size(); x++) {
                    String otherRowOfTrees = inputList.get(x);
                    if (j != x) {
                        char otherTree = otherRowOfTrees.charAt(k);
                        int otherTreeHeight = otherTree - '0';
                        // check above then check below
                        if (j > x && treeHeight <= otherTreeHeight) {
                            aboveVision = j-x;
                        } else if (treeHeight <= otherTreeHeight) {
                            if (!alreadyCheckedBelow) {
                                belowVision = x-j;
                                alreadyCheckedBelow = true;
                            }
                        }
                    }
                }
                if (bestScenicValue < leftVision * rightVision * aboveVision * belowVision) {
                    bestScenicValue = leftVision * rightVision * aboveVision * belowVision;
                }

            }

        }
        return bestScenicValue;
    }

}
