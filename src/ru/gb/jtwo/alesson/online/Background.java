package ru.gb.jtwo.alesson.online;


import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Background {
    MainCanvas canvas;
    private Timer mTimer;
    int red, green, blue;

    Background(MainCanvas canvas) {
        this.canvas = canvas;
        canvas.setBackground(Color.black);


        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        TimerTask TimerTaskSetBgColor = new TimerTask() {
            @Override
            public void run() {
                Color getColor = canvas.getBackground();

                if (getColor.getRed() < 254) {
                    red = getColor.getRed() + 5;
                }
                else if (getColor.getRed() == 255 && getColor.getGreen() < 254) {
                    green = getColor.getGreen() + 5;
                }
                else if (getColor.getRed() == 255 && getColor.getGreen() == 255 && getColor.getBlue() < 254) {
                    blue = getColor.getBlue() + 5;
                } else {
                    red = (int) (Math.random() * 51) * 5;
                    green = (int) (Math.random() * 51) * 5;
                    blue = (int) (Math.random() * 51) * 5;
                }

                //System.out.println(getColor);


                Color colorPanel = new Color(red,
                        green,
                        blue);
                canvas.setBackground(colorPanel);
            }
        };

        mTimer.schedule(TimerTaskSetBgColor, 10, 50);

    }
}
