package ru.gb.jtwo.blesson.online.games.common;

import ru.gb.jtwo.blesson.online.games.circles.MainWindow;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    MainCanvasListener gameController;
    long lastFrame;

    public MainCanvas(MainCanvasListener gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrame) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrame = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }


    public int getLeft() { return 0; }

    public int getRight() { return getWidth() - 1; }

    public int getTop() { return 0; }

    public int getBottom() { return getHeight() - 1; }
}
