package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import shapes.Point;
import shapes.Shape;
import shapes.Line;
import shapes.Circle;
import shapes.Oval;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Square;
import shapes.Triangle;

public class PaintingArea extends JPanel {
    List<Shape> shapeList;

    public PaintingArea() {
        shapeList = new ArrayList<>();
        setSize(680, 600);
    }

    public Shape getShapeByPoint(Point p) {
        for (Shape s : shapeList)
            if (s.hit(p))
                return s;

        return null;
    }

    public void moveShape(Point p, int xMove, int yMove) {
        Shape s = getShapeByPoint(p);

        if (s != null) {
            s.move(xMove, yMove);
            reDrawAll();
        }
    }
    
    public void reDrawAll() {
        // first you kinda erase the board by putting a white rectangle on it!
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // then you redraw all the current shapes
        for (Shape s : shapeList)
            s.draw(g);
    }
}
