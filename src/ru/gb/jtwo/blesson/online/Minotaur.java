package ru.gb.jtwo.blesson.online;

public class Minotaur implements Human, Bull {
    @Override
    public void voice() {
        System.out.println("mooOOmooo");
    }

    @Override
    public void talk() {
        System.out.println("quiz");
    }

    @Override
    public void walk() {
        Bull.super.walk();
    }

    @Override
    public void breathe() {

    }

    @Override
    public void look() {

    }
}
