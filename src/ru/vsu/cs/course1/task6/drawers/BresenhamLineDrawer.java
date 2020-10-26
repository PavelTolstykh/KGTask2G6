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
        double dy = Math.abs(y2 - y1);
        double dx = Math.abs(x2 - x1);
        int x, y;
        if (Math.abs(dy) > Math.abs(dx)) {
            double shift = dx + 1;
            double sum = 0;
            if (y1 > y2) {
                x1 = x1 ^ x2 ^ (x2 = x1);
                y1 = y1 ^ y2 ^ (y2 = y1);
            }
            for (x = x1, y = y1; y <= y2; y++) {
                pd.drawPixel(x, y, Color.BLACK);
                sum += shift;
                if (sum >= dy + 1) {
                    sum -= dy + 1;
                    x += x2 > x1 ? 1 : -1;
                }
            }
        } else {
            double shift = dy + 1;
            double sum = 0;
            if (x1 > x2) {
                x1 = x1 + x2 + (x2 = x1);
                y1 = y1 + y2 + (y2 = y1);
            }
            for (x = x1, y = y1; x <= x2; x++) {
                pd.drawPixel(x, y, Color.BLACK);
                sum += shift;
                if (sum >= dx + 1) {
                    sum -= dx + 1;
                    y += y2 > y1 ? 1 : -1;
                }
            }
        }
    }
}
