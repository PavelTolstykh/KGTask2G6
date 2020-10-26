package ru.vsu.cs.course1.task6;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() throws HeadlessException {
        dp = new DrawPanel();
        Label label = new Label("Алгоритм: ");
        label.setAlignment(Label.LEFT);
        JComboBox comboBox = new JComboBox(Algs.values());
        comboBox.setEditable(false);

        this.add(dp);
    }
}
