package ru.vsu.cs.course1.task6;

import ru.vsu.cs.course1.task6.drawers.BresenhamLineDrawer;
import ru.vsu.cs.course1.task6.drawers.DDALineDrawer;
import ru.vsu.cs.course1.task6.drawers.GraphicsLineDrawer;
import ru.vsu.cs.course1.task6.drawers.WuLineDrawer;
import ru.vsu.cs.course1.task6.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    private int algNum = 0;// глянь

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics gr = bi.createGraphics();
        PixelDrawer pd = new GraphicsPixelDrawer(gr);
        LineDrawer ld = new DDALineDrawer(pd);
        LineDrawer bld = new BresenhamLineDrawer(pd);
        LineDrawer wld = new WuLineDrawer(pd);
        gr.setColor(Color.WHITE);// посмотри
        gr.fillRect(0, 0, getWidth(), getHeight());
        gr.setColor(Color.BLACK);
        actualDraw(wld);
        g.drawImage(bi, 0, 0, null);
        gr.dispose();
    }

    private void drawAll(LineDrawer ld, int dx, int dy) {

    }

    private void actualDraw(LineDrawer ld) {
        DrawUtils.drawSnowflake(ld, getWidth()/2 + 150, getHeight()/2 + 200, 80, 60);
        ld.drawLine(getWidth()/2, getHeight()/2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
