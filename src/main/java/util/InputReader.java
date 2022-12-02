package main.java.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static String getInputAsString(int day) {
        StringBuilder inputString = new StringBuilder();
        String file = getFile(day);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputString.append(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputString.toString();
    }

    public static List<String> getInputAsList(int day) {
        List<String> inputList = new ArrayList<>();
        String file = getFile(day);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputList;
    }

    public static String getFile(int day) {
        return "./src/main/resources/input_day_" + day + ".txt";
    }
}