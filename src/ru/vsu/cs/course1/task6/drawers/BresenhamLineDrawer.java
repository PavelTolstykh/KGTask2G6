package ru.vsu.cs.course1.task6.drawers;

import ru.vsu.cs.course1.task6.GraphicsPixelDrawer;
import ru.vsu.cs.course1.task6.LineDrawer;
import ru.vsu.cs.course1.task6.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    public void drawBresenhamLine (int x1, int y1, int x2, int y2) {
        int x, y, dx, dy, signX, signY, delX, delY, shift, end, f;
        signX = Integer.compare(x2 - x1, 0);
        signY = Integer.compare(y2 - y1, 0);
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        if (dx > dy) {
            delX = signX;	delY = 0;
            shift = dy;	end = dx;
        }
        else
        {
            delX = 0;	delY = signY;
            shift = dx;	end = dy;
        }

        x = x1;
        y = y1;
        f = end/2;
        pd.drawPixel(x, y, Color.BLACK);

        for (int t = 0; t < end; t++) {
            f -= shift;
            if (f < 0) {
                f += end;
                x += signX;
                y += signY;
            } else {
                x += delX;
                y += delY;
            }
            pd.drawPixel(x, y, Color.BLACK);
        }
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        drawBresenhamLine(x1, y1, x2, y2);

//        double dy = Math.abs(y2 - y1);
//        double dx = Math.abs(x2 - x1);
//        int x, y;
//        if (dy >= dx) {
//            double shift = dx + 1;
//            double sum = 0;
//            if (y1 > y2) {
//                int tmp = x1;
//                x1 = x2;
//                x2 = tmp;
//                tmp = y1;
//                y1 = y2;
//                y2 = tmp;
//            }
//            for (x = x1, y = y1; y < y2; y++) {
//                pd.drawPixel(x, y, Color.BLACK);
//                sum += shift;
//                if (sum >= dy + 1) {
//                    sum -= dy + 1;
//                    x += x2 > x1 ? 1 : -1;
//                }
//            }
//        } else {
//            double shift = dy + 1;
//            double sum = 0;
//            if (x1 > x2) {
//                int tmp = x1;
//                x1 = x2;
//                x2 = tmp;
//                tmp = y1;
//                y1 = y2;
//                y2 = tmp;
//            }
//            for (x = x1, y = y1; x < x2; x++) {
//                pd.drawPixel(x, y, Color.BLACK);
//                sum += shift;
//                if (sum >= dx + 1) {
//                    sum -= dx + 1;
//                    y += y2 > y1 ? 1 : -1;
//                }
//            }
//        }
    }
}
