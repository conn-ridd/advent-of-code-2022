package main.java.days;
import main.java.util.InputReader;
import java.util.ArrayList;
import java.util.List;

public class Day7 {
    private final List<Directory> directoriesList = new ArrayList<>();
    private final List<Directory> currentPath = new ArrayList<>();
    private final List<String> inputList = InputReader.getInputAsList(7);
    public int answerPart1() {
        Directory root = new Directory();
        this.directoriesList.add(root);
        this.currentPath.add(root);
        for (String terminalIO: inputList) {
            String prefix = terminalIO.split(" ")[0];
            if (prefix.equals("$")) {
                dealWithCommand(terminalIO);
            } else if (!prefix.equals("dir")) {
                dealWithFile(terminalIO);
            }
        }
        return count();
    }

    public int count() {
        int sum = 0;
        for (Directory directory: this.directoriesList) {
            if (directory.getSize() <= 100000) {
                sum += directory.getSize();
            }
        }
        return sum;
    }

    public void dealWithCommand(String terminalIO) {
        if (terminalIO.equals("$ ls") || terminalIO.equals("$ cd /")) {
            return;
        }
        String directoryName = terminalIO.split(" ")[2];
        if (directoryName.equals("..")) {
            this.currentPath.get(this.currentPath.size()-1).setHasBeenVisited(true);
            this.currentPath.remove(this.currentPath.size()-1);
        } else {
            this.currentPath.get(this.currentPath.size()-1).setHasBeenVisited(true);
            this.directoriesList.add(new Directory(directoryName, this.currentPath));
            this.currentPath.add(this.directoriesList.get(this.directoriesList.size()-1));
        }
    }

    public void dealWithFile(String terminalIO) {
        Directory currentDirectory = this.currentPath.get(this.currentPath.size()-1);
        if (!currentDirectory.isHasBeenVisited()) {
            int fileSize = Integer.parseInt(terminalIO.split(" ")[0]);
            for (Directory directory: this.currentPath) {
                int currentSize = directory.getSize();
                directory.setSize(currentSize + fileSize);
            }
        }
    }

    public int answerPart2() {
        int currentUnusedSpace = 70000000 - directoriesList.get(0).getSize();
        int currentSmallestToDelete = directoriesList.get(0).getSize();
        for (Directory directory: directoriesList) {
            int directorySize = directory.getSize();
            if (directorySize + currentUnusedSpace >= 30000000 && directorySize < currentSmallestToDelete) {
                currentSmallestToDelete = directorySize;
            }
        }
        return currentSmallestToDelete;
    }
}

























