package main.java.days;
import main.java.util.InputReader;
import java.util.ArrayList;
import java.util.List;

public class Day7 {
    private final List<String> inputList = InputReader.getInputAsList(7);
    private final List<String> directoryNames = new ArrayList<>();
    private final List<Integer> directoryContents = new ArrayList<>();
    private final List<Boolean> hasEachDirectoryBeenVisitedBefore = new ArrayList<>();
    public int answerPart1() {
        int totalSumDirectories = 0;
        List<String> currentPath = new ArrayList<>();
        currentPath.add("/");
        directoryNames.add("/");
        directoryContents.add(0);
        hasEachDirectoryBeenVisitedBefore.add(false);
        for (String element: inputList) {
            if (element.equals("$ cd ..")) {
                // set a marker so that we know we've already added its direct contents
                String currentDirectory = currentPath.get(currentPath.size()-1);
                int indexOfCurrentDirectory = directoryNames.indexOf(currentDirectory);
                hasEachDirectoryBeenVisitedBefore.set(indexOfCurrentDirectory, true);
                currentPath.remove(currentPath.size()-1);

            } else if (element.contains("$ cd") && !element.equals("$ cd /")) {
                // set a marker so that we know we've already added its direct contents
                String currentDirectory = currentPath.get(currentPath.size() - 1);
                int indexOfCurrentDirectory = directoryNames.indexOf(currentDirectory);
                hasEachDirectoryBeenVisitedBefore.set(indexOfCurrentDirectory, true);
                currentPath.add(element.substring(5));

            } else if (!element.equals("$ ls") && element.substring(0,3).equals("dir")) {
                String directoryName = element.substring(4);
                if (!directoryNames.contains(directoryName)) {
                    directoryNames.add(directoryName);
                    directoryContents.add(0);
                    hasEachDirectoryBeenVisitedBefore.add(false);
                }

            } else if (!element.equals("$ ls") && !element.equals("$ cd /")) {
                String currentDirectory = currentPath.get(currentPath.size()-1);
                int indexOfCurrentDirectory = directoryNames.indexOf(currentDirectory);
                if (!hasEachDirectoryBeenVisitedBefore.get(indexOfCurrentDirectory)) {
                    String sizeOfFileString = element.split(" ")[0];
                    int sizeOfFile = Integer.parseInt(sizeOfFileString);
                    for (String directory: currentPath) {
                        int indexOfDirectory = directoryNames.indexOf(directory);
                        int currentSize = directoryContents.get(indexOfDirectory);
                        directoryContents.set(indexOfDirectory, currentSize + sizeOfFile);
                    }
                }
            }
//            System.out.println("================");
//            System.out.println("Path: " + currentPath);
//            System.out.println("Currently discovered directories: " + directoryNames);
//            System.out.println("Current known sizes: " + directoryContents);
        }

        for (int directorySize: directoryContents) {
            int index = directoryContents.indexOf(directorySize);
            String name = directoryNames.get(index);
            if (directorySize <= 100000 ) {
                totalSumDirectories += directorySize;
            }
            if (directorySize == 0) {
                System.out.println(name);
            }
            if (directoryNames.lastIndexOf(name) != directoryNames.indexOf(name)) {
                System.out.println(name + " occurs multiple times!");
            }
        }
        System.out.println("Currently discovered directories: " + directoryNames);
        System.out.println("Current known sizes: " + directoryContents);
        System.out.println(directoryContents.size());
        System.out.println(directoryNames.size());
        return totalSumDirectories;
    }

    public int betterAnswerPart1() {
        int sumOfContents = 0;



        return sumOfContents;
    }
}
