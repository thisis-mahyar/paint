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
                        if (p1 == null) {
                            p1 = new Point(e.getX(), e.getY());
                        } else if (p2 == null) {
                            p2 = new Point(e.getX(), e.getY());

                            moveShape(p1, p2.getX() - p1.getX(), p2.getY() - p1.getY());

                            p1 = null;
                            p2 = null;
                        }
                        break;

                    case ZOOM_IN:
                        p1 = new Point(e.getX(), e.getY());
                        p2 = new Point(e.getX(), e.getY());

                        s = getShapeByPoint(p1);

                        if (s != null) {
                            switch (s) {
                                case Line line:
                                    line.p2.setX(line.p1.getX() + (line.p2.getX() - line.p1.getX()) * 2);
                                    line.p2.setY(line.p1.getY() + (line.p2.getY() - line.p1.getY()) * 2);
                                    break;

                                case Rectangle rectangle:
                                    rectangle.p2.setX(rectangle.p1.getX() + (rectangle.p2.getX() - rectangle.p1.getX()) * 2);
                                    rectangle.p2.setY(rectangle.p1.getY() + (rectangle.p2.getY() - rectangle.p1.getY()) * 2);
                                    break;

                                case Oval oval:
                                    oval.axis1 *= 2;
                                    oval.axis2 *= 2;
                                    break;

                                case Triangle triangle:
                                    triangle.points.get(2).setX(triangle.points.get(1).getX() + (triangle.points.get(2).getX() - triangle.points.get(1).getX()) * 2);
                                    triangle.points.get(2).setY(triangle.points.get(1).getY() + (triangle.points.get(2).getY() - triangle.points.get(1).getY()) * 2);
                                    triangle.points.get(3).setX(triangle.points.get(1).getX() + (triangle.points.get(3).getX() - triangle.points.get(1).getX()) * 2);
                                    triangle.points.get(3).setY(triangle.points.get(1).getY() + (triangle.points.get(3).getY() - triangle.points.get(1).getY()) * 2);
                                    break;

                                case Polygon polygon:
                                    for (int i = 0; i < polygon.points.size(); i++) {
                                        ((Polygon) s).points.get(i).setX((((Polygon) s).points.get(0).getX() + (((Polygon) s).points.get(i).getX() - ((Polygon) s).points.get(0).getX()) * 2));
                                        ((Polygon) s).points.get(i).setY((((Polygon) s).points.get(0).getY() + (((Polygon) s).points.get(i).getY() - ((Polygon) s).points.get(0).getY()) * 2));
                                        ((Polygon) s).points.get(i).setX((((Polygon) s).points.get(0).getX() + (((Polygon) s).points.get(i).getX() - ((Polygon) s).points.get(0).getX()) * 2));
                                        ((Polygon) s).points.get(i).setY((((Polygon) s).points.get(0).getY() + (((Polygon) s).points.get(i).getY() - ((Polygon) s).points.get(0).getY()) * 2));
                                    }
                                    break;

                                default:
                                    break;
                            }

                            paintAll(getGraphics());
                        }

                        p1 = null;
                        p2 = null;

                        break;

                    case ZOOM_OUT:
                        p1 = new Point(e.getX(), e.getY());
                        p2 = new Point(e.getX(), e.getY());

                        s = getShapeByPoint(p1);

                        if (s != null) {
                            switch (s) {
                                case Line line:
                                    line.p2.setX(line.p1.getX() + (line.p2.getX() - line.p1.getX()) / 2);
                                    line.p2.setY(line.p1.getY() + (line.p2.getY() - line.p1.getY()) / 2);
                                    break;

                                case Rectangle rectangle:
                                    rectangle.p2.setX(rectangle.p1.getX() + (rectangle.p2.getX() - rectangle.p1.getX()) / 2);
                                    rectangle.p2.setY(rectangle.p1.getY() + (rectangle.p2.getY() - rectangle.p1.getY()) / 2);
                                    break;

                                case Oval oval:
                                    oval.axis1 /= 2;
                                    oval.axis2 /= 2;
                                    break;

                                case Triangle triangle:
                                    triangle.points.get(2).setX(triangle.points.get(1).getX() + (triangle.points.get(2).getX() - triangle.points.get(1).getX()) / 2);
                                    triangle.points.get(2).setY(triangle.points.get(1).getY() + (triangle.points.get(2).getY() - triangle.points.get(1).getY()) / 2);
                                    triangle.points.get(3).setX(triangle.points.get(1).getX() + (triangle.points.get(3).getX() - triangle.points.get(1).getX()) / 2);
                                    triangle.points.get(3).setY(triangle.points.get(1).getY() + (triangle.points.get(3).getY() - triangle.points.get(1).getY()) / 2);
                                    break;

                                case Polygon polygon:
                                    for (int i = 0; i < polygon.points.size(); i++) {
                                        ((Polygon) s).points.get(i).setX((((Polygon) s).points.get(0).getX() + (((Polygon) s).points.get(i).getX() - ((Polygon) s).points.get(0).getX()) / 2));
                                        ((Polygon) s).points.get(i).setY((((Polygon) s).points.get(0).getY() + (((Polygon) s).points.get(i).getY() - ((Polygon) s).points.get(0).getY()) / 2));
                                        ((Polygon) s).points.get(i).setX(((Polygon) s).points.get(0).getX() + (((Polygon) s).points.get(i).getX() - ((Polygon) s).points.get(0).getX()) / 2);
                                        ((Polygon) s).points.get(i).setY(((Polygon) s).points.get(0).getY() + (((Polygon) s).points.get(i).getY() - ((Polygon) s).points.get(0).getY()) / 2);
                                    }
                                    break;

                                default:
                                    break;
                            }

                            paintAll(getGraphics());
                        }

                        p1 = null;
                        p2 = null;

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
