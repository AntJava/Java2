package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainCanvas extends JPanel {

    public class btnAddActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gameController.onActionHandler("add");
        }
    }

    public class btnDelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gameController.onActionHandler("del");
        }
    }

    MainWindow gameController;
    long lastFrame;

    MainCanvas(MainWindow gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();

        JButton btnAdd = new JButton("Add ball");
        JButton btnDel = new JButton("Delete ball");

        ActionListener actionListenerAdd = new btnAddActionListener();
        ActionListener actionListenerDel = new btnDelActionListener();

        btnAdd.addActionListener(actionListenerAdd);
        btnDel.addActionListener(actionListenerDel);

        add(btnAdd);
        add(btnDel);
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



