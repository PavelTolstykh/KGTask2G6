package ru.vsu.cs.course1.task6.drawers;

import ru.vsu.cs.course1.task6.LineDrawer;
import ru.vsu.cs.course1.task6.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dy, dx;
        dy = y2 - y1;
        dx = x1 - x2;
        int f = 0;
        pd.drawPixel(x1, y1, Color.RED);
        int x = x1, y = y1;
        if (Math.abs(dy) <= Math.abs(dx)) {
            do {
                f += dy < 0 ? dy*(-1) : dy;
                if (f > 0) {
                    f -= dx < 0 ? dx*(-1) : dx;
                    y += dy < 0 ? -1 : 1;
                }
                x -= dx < 0 ? -1 : 1;
                pd.drawPixel(x, y, Color.RED);
            } while (x != x2 || y != y2);
        } else {
            do {
                f += dx < 0 ? dx*(-1) : dx;
                if (f > 0) {
                    f -= dy < 0 ? dy*(-1) : dy;
                    x -= dx < 0 ? -1 : 1;
                }
                y += dy < 0 ? -1 : 1;
                pd.drawPixel(x, y, Color.BLUE);
            } while (x != x2 || y != y2);
        }
    }
}
