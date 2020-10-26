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
        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
        if (steep) {
            int tmp = x1;
            x1 = y1;
            y1 = tmp;
            tmp = x2;
            x2 = y2;
            y2 = tmp;
        }
        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        double dx = x2 - x1;
        double dy = y2 - y1;
        double gradient = dx == 0 ? 1 : dy / dx;
        int xend = Math.round(x1);
        double yend = y1 + gradient * (xend - x1);
        double xgap = 1 - (x1 + 0.5) + Math.floor(x1 + 0.5);
        int xpxl1 = xend;
        int ypxl1 = (int)Math.floor(yend);
        if (steep) {
            pd.drawPixel(ypxl1, xpxl1, new Color((int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap) , (int)(255 * (1 - yend + Math.floor(yend)) * xgap)));
            pd.drawPixel(ypxl1 + 1, xpxl1, new Color((int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap)));
        } else {
            pd.drawPixel(xpxl1, ypxl1, new Color((int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap)));
            pd.drawPixel(xpxl1, ypxl1 + 1, new Color((int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap)));
        }
        double del = yend + gradient;
        xend = Math.round(x2);
        yend = y2 + gradient * (xend - x2);
        xgap = (x1 + 0.5) - Math.floor(x1 + 0.5);
        int xpxl2 = xend;
        int ypxl2 = (int)Math.floor(yend);
        if (steep) {
            pd.drawPixel(ypxl2, xpxl2, new Color((int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap)));
            pd.drawPixel(ypxl2 + 1, xpxl2, new Color((int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap)));
        } else {
            pd.drawPixel(xpxl2, ypxl2, new Color((int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap), (int)(255 * (1 - yend + Math.floor(yend)) * xgap)));
            pd.drawPixel(xpxl2, ypxl2 + 1, new Color((int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap), (int)(255 * (yend - Math.floor(yend)) * xgap)));
        }
        if (steep) {
            for (int i = xpxl1 + 1; i <= xpxl2 - 1; i++) {
                pd.drawPixel((int)Math.floor(del), i, new Color((int)((1 - del + Math.floor(del)) * 255), (int)((1 - del + Math.floor(del)) * 255), (int)((1 - del + Math.floor(del)) * 255)));
                pd.drawPixel((int)Math.floor(del) + 1, i, new Color((int)((del - Math.floor(del)) * 255), (int)((del - Math.floor(del)) * 255), (int)((del - Math.floor(del)) * 255)));
                del += gradient;
            }
        } else {
            for (int i = xpxl1 + 1; i <= xpxl2 - 1; i++) {
                pd.drawPixel(i, (int)Math.floor(del), new Color((int)((1 - del + Math.floor(del)) * 255), (int)((1 - del + Math.floor(del)) * 255), (int)((1 - del + Math.floor(del)) * 255)));
                pd.drawPixel(i, (int)Math.floor(del) + 1, new Color((int)((del - Math.floor(del)) * 255), (int)((del - Math.floor(del)) * 255), (int)((del - Math.floor(del)) * 255)));
                del += gradient;
            }
        }
    }
}
