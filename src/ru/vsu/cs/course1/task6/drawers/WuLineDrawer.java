package ru.vsu.cs.course1.task6.drawers;

import ru.vsu.cs.course1.task6.LineDrawer;
import ru.vsu.cs.course1.task6.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    Color c = new Color(255, 255, 255);

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        boolean isSwap = false;
        if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
            int tmp = x1;
            x1 = y1;
            y1 = tmp;
            tmp = x2;
            x2 = y2;
            y2 = tmp;
            isSwap = true;
        }
        if (x2 < x1) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (dx == 0) {
            if (x1 == x2) {
                for (int y = y1; y < y2; y++) {
                    pd.drawPixel(x1, y, Color.BLACK);
                }
            } else {
                for (int x = x1; x < x2; x++) {
                    pd.drawPixel(x, y1, Color.BLACK);
                }
            }
            return;
        }
        if (isSwap) {
            pd.drawPixel(y1, x1, Color.BLACK);
        } else {
            pd.drawPixel(x1, y1, Color.BLACK);
        }
        double gradient = dy / dx;
        double del = y1 + gradient;
        for (int i = x1 + 1; i < x2; i++) {
            if (isSwap) {
                pd.drawPixel((int) del, i, new Color(0, 0, 0, (int) (255 * (1 - del + (int) del))));
                pd.drawPixel((int) del + 1, i, new Color(0, 0, 0, (int) (255 * (del - (int) del))));
            } else {
                pd.drawPixel(i, (int) del, new Color(0, 0, 0, (int) (255 * (1 - del + (int) del))));
                pd.drawPixel(i, (int) del + 1, new Color(0, 0, 0, (int) (255 * (del - (int) del))));
            }
            del += gradient;
        }
        if (isSwap) {
            pd.drawPixel(y2, x2, Color.BLACK);
        } else {
            pd.drawPixel(x2, y2, Color.BLACK);
        }
    }
}
