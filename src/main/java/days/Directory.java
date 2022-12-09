package main.java.days;

import java.awt.*;
import java.util.ArrayList;

public class Directory {
    private int depth;
    private String parentDirectory;
    private int directContentsSum;
    private int totalContentSum;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public int getDirectContentsSum() {
        return directContentsSum;
    }

    public void setDirectContentsSum(int directContentsSum) {
        this.directContentsSum = directContentsSum;
    }

    public int getTotalContentSum() {
        return totalContentSum;
    }

    public void setTotalContentSum(int totalContentSum) {
        this.totalContentSum = totalContentSum;
    }
}
