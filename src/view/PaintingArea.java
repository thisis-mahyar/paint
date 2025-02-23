package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shapes.*;
import shapes.Point;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Shape;

public class PaintingArea extends JPanel {
    List<Shape> shapes;
    private Point p1, p2, p3;

    private ArrayList<Integer> xs = new ArrayList<>();
    private ArrayList<Integer> ys = new ArrayList<>();

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
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    Line line = new Line(p1, p2, menu.borderColor);

                                    shapes.add(line);
                                    paintComponent(getGraphics());

                                    p1 = p2 = null;
                                }
                                break;

                            case RECTANGLE:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    Rectangle rectangle = new Rectangle(p1, p2, menu.borderColor, menu.fillColor);

                                    rectangle.isFilled = menu.isFilledCheckBox.isSelected();

                                    shapes.add(rectangle);
                                    paintComponent(getGraphics());

                                    p1 = p2 = null;
                                }
                                break;

                            case CIRCLE:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    Circle circle = new Circle(p1, (int) p1.distance(p2), menu.borderColor, menu.fillColor);

                                    circle.isFilled = menu.isFilledCheckBox.isSelected();

                                    shapes.add(circle);
                                    paintComponent(getGraphics());

                                    p1 = p2 = null;
                                }
                                break;

                            case TRIANGLE:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else if (p2 == null) {
                                    p2 = new Point(e.getX(), e.getY());
                                } else {
                                    p3 = new Point(e.getX(), e.getY());

                                    Triangle triangle = new Triangle(p1, p2, p3, menu.borderColor, menu.fillColor);

                                    triangle.isFilled = menu.isFilledCheckBox.isSelected();

                                    shapes.add(triangle);
                                    paintComponent(getGraphics());

                                    p1 = p2 = p3 = null;
                                }
                                break;

                            case SQUARE:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    Square square = new Square(p1, p2, menu.borderColor, menu.fillColor);

                                    square.isFilled = menu.isFilledCheckBox.isSelected();

                                    shapes.add(square);
                                    paintComponent(getGraphics());

                                    p1 = p2 = null;
                                }
                                break;

                            case OVAL:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    Oval oval = new Oval(p1, Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()), menu.borderColor, menu.fillColor);

                                    oval.isFilled = menu.isFilledCheckBox.isSelected();

                                    shapes.add(oval);
                                    paintComponent(getGraphics());

                                    p1 = p2 = null;
                                }
                                break;

                            case POLYGON:
                                if (p1 == null) {
                                    p1 = new Point(e.getX(), e.getY());

                                    // for the beginning point and tolerance
                                    Circle circle = new Circle(p1, 5, Color.BLACK, Color.BLACK);
                                    shapes.add(circle);
                                    paintComponent(getGraphics());

                                    xs.add(p1.getX());
                                    ys.add(p1.getY());
                                } else {
                                    p2 = new Point(e.getX(), e.getY());

                                    if (Math.abs(p2.getX() - xs.getLast()) < 10 && Math.abs(p2.getY() - ys.getLast()) < 10) {
                                        Point[] points = new Point[xs.size()];

                                        for (int i = 0; i < xs.size(); i++) {
                                            points[i] = new Point();
                                            points[i].setX(xs.get(i));
                                            points[i].setY(ys.get(i));
                                        }

                                        Polygon polygon = new Polygon(Arrays.stream(points).toList(), menu.borderColor, menu.fillColor);

                                        polygon.isFilled = menu.isFilledCheckBox.isSelected();

                                        shapes.add(polygon);
                                        paintComponent(getGraphics());

                                        xs.clear();
                                        ys.clear();

                                        p1 = p2 = null;
                                    } else {
                                        xs.add(p2.getX());
                                        ys.add(p2.getY());

                                        p2 = null;
                                    }
                                }
                                break;
                        }
                        break;

                    case ERASE:
                        p1 = new Point(e.getX(), e.getY());

                        Shape s = getShapeByPoint(p1);

                        if (s != null) {
                            shapes.remove(s);
                            remove(s);
                            paintComponent(getGraphics());
                        }

                        p1 = null;

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
