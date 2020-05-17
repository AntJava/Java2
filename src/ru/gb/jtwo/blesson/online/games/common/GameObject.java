package ru.gb.jtwo.blesson.online.games.common;

import java.awt.*;

public interface GameObject {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
