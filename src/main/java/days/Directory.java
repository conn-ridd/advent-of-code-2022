package main.java.days;

import java.util.List;

public class Directory {
    private int size;
    private String name;
    private Directory parent;
    private boolean hasBeenVisited;
    public Directory(String name, List<Directory> path) {
        this.size = 0;
        this.hasBeenVisited = false;
        this.name = name;
        this.parent = path.get(path.size()-1);
    }

    public Directory() {
        this.size = 0;
        this.hasBeenVisited = false;
        this.name = "root";
        this.parent = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public boolean isHasBeenVisited() {
        return hasBeenVisited;
    }

    public void setHasBeenVisited(boolean hasBeenVisited) {
        this.hasBeenVisited = hasBeenVisited;
    }
}
