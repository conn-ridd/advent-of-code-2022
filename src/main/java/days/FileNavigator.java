//package main.java.days;
//
//import java.util.ArrayList;
//
//public class FileNavigator {
//    private String currentDirectory;
//    private String parentDirectory;
//    private ArrayList<String> path;
//    private ArrayList<Directory> directoryList;
//    private ArrayList<String> directoryNamesList;
//
//    public FileNavigator() {
//        this.currentDirectory = "/";
//        this.directoryList = new ArrayList<>();
//        this.directoryNamesList = new ArrayList<>();
//        this.directoryNamesList.add("/");
//        this.path = new ArrayList<>();
//        this.path.add("/");
//        Directory rootDirectory = new Directory(this.path);
//    }
//
//    public void updateDirectory(String command) {
//        if (command.contains("$ cd")) {
//            changeDirectory(command);
//        }
//    }
//
//    public void changeDirectory(String command) {
//        String[] splitCommand = command.split(" ");
//        if (splitCommand[splitCommand.length - 1].equals("..")) {
//            this.currentDirectory = parentDirectory;
//        } else this.currentDirectory = splitCommand[splitCommand.length - 1];
//    }
//
//    public String getCurrentDirectory() {
//        return this.currentDirectory;
//    }
//
//    public void processCommand(String command) {
//        updateDirectory(command);
//
//    }
//
//    public void scanThroughInput(ArrayList<String> input) {
//        for (String command: input) {
//            processCommand(command);
//        }
//    }
//
//}
