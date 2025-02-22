package shapes;

import java.awt.*;

public class Line extends Shape {
    public Point p1, p2;

    public Line() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.name = "line-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = Color.BLACK;
    }

    public Line(Point p1, Point p2, Color borderColor) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = "line-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(borderColor);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        System.out.format("draw %s from %s to %s.\n", name, p1.toString(), p2.toString());
    }

    @Override
    public void move(int xMove, int yMove) {
        p1.setX(p1.getX() + xMove);
        p1.setY(p1.getY() + yMove);
        p2.setX(p2.getX() + xMove);
        p2.setY(p2.getY() + yMove);
    }

    @Override
    public void erase() { // yet just a message
        System.out.format("erase %s.\n", name);
    }

    @Override
    public boolean hit(Point p) {
        return p1.distance(p2) == p1.distance(p) + p2.distance(p);
    }
}