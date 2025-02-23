package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import shapes.Point;
import shapes.Shape;

public class PaintingArea extends JPanel {
    List<Shape> shapes;

    public PaintingArea() {
        shapes = new ArrayList<>();
        setSize(680, 600);
    }

    public Shape getShapeByPoint(Point p) {
        for (Shape s : shapes)
            if (s.hit(p))
                return s;

        return null;
    }

    public void moveShape(Point p, int xMove, int yMove) {
        Shape s = getShapeByPoint(p);

        if (s != null) {
            s.move(xMove, yMove);
            paintComponent(getGraphics());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // clears the background

        for (Shape shape : shapes)
            shape.paintComponent(g);
    }
}
