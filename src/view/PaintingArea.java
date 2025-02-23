package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import shapes.Point;
import shapes.Shape;

public class PaintingArea extends JPanel {
    List<Shape> shapes;
    private Point p1, p2, p3;

    public PaintingArea(Menu menu) {
        shapes = new ArrayList<>();
        setSize(680, 600);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (menu.currentAction) {
                    case DRAW:
                        switch (menu.currentShape) {
                            case LINE:
                                break;
                            case RECTANGLE:
                                break;
                            case CIRCLE:
                                break;
                            case TRIANGLE:
                                break;
                            case SQUARE:
                                break;
                            case OVAL:
                                break;
                            case POLYGON:
                                break;
                        }
                        break;
                    case ERASE:
                        break;
                    case MOVE:
                        break;
                    case ZOOM_IN:
                        break;
                    case ZOOM_OUT:
                        break;
                }
            }
        });
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
