package view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Paint");
        setSize(800, 600);

        Menu menu = new Menu();
        PaintingArea paintingArea = new PaintingArea(menu);

        getContentPane().setLayout(new BorderLayout());

        add(menu, BorderLayout.WEST);
        add(paintingArea, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame().setVisible(true));
    }
}
