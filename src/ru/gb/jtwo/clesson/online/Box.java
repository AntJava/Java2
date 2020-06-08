package ru.gb.jtwo.clesson.online;

import java.util.Objects;

public class Box extends Object implements Comparable<Box> {
    int width;
    int height;

    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Box(%d, %d)", width, height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Box)) return false;
        Box box = (Box) obj;
        return this.width == box.width && this.height == box.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    private int square() {
        return height * width;
    }

    @Override
    public int compareTo(Box o) {
        return (o == this) ? 0 : square() - o.square();
//        if (this.square() < o.square())
//            return -1;
//        else if (this.square() > o.square())
//            return 1;
//        else
//            return 0;
    }
}
