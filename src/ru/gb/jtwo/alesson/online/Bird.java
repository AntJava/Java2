package ru.gb.jtwo.alesson.online;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    void fly() {
        System.out.println(name + " flies");
    }
}
