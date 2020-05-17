package ru.gb.jtwo.blesson.online;

public interface Bull extends Animal {
    void voice();
    default void walk() {
        System.out.println("walks on hooves");
    }
}
