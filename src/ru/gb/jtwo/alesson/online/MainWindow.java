package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainWindow extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        initApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);
        Background col = new Background(canvas);
    }


    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private Sprite[] del(Sprite[] arr, int i) {
        if (i >= 0 && i < arr.length) {
            Sprite[] copy = new Sprite[arr.length - 1];
            System.arraycopy(arr, 0, copy, 0, i);
            System.arraycopy(arr, i, copy, i, arr.length - i - 1);
            return copy;
        } else return new Sprite[0];
    }

    private Sprite[] add(Sprite[] arr) {
        Sprite[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1]= new Ball();
        return newArr;
    }

    void onActionHandler(String action) {
        int helperVar = sprites.length;
        Sprite[] helper = sprites;
        switch (action) {
            case "add":
                sprites = add(helper);
                break;
            case "del":
                sprites = del(helper, 1);
                break;
            default:
                break;
        }
    }

    private static void method1(Animal a) {
        a.name = "Barsik";
    }

    private static void sum(int a, int b) {

    }

    private static void typecastExample() {
        Cat c = new Cat("Barsik");
        Bird b = new Bird("Chijik");

        Animal[] zoo = {c, b};

        for (int i = 0; i < zoo.length; i++) {
            zoo[i].walk();

            if (zoo[i] instanceof Bird) {
                ( (Bird) zoo[i] ).fly();
            }
        }
    }
}
