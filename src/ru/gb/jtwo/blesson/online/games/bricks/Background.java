package ru.gb.jtwo.blesson.online.games.bricks;

import ru.gb.jtwo.blesson.online.games.common.GameObject;
import ru.gb.jtwo.blesson.online.games.common.MainCanvas;

import java.awt.*;

public class Background implements GameObject {

    @Override
    public void update(MainCanvas canvas, float deltaTime) {

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(Color.BLACK);
    }
}
