package shapes;

import java.awt.*;

public class Rectangle extends Shape {
    public Point p1, p2;

    public Rectangle() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.name = "rectangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;
    }

    public Rectangle(Point p1, Point p2, Color borderColor, Color fillColor) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = "rectangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (!isFilled) {
            g.setColor(borderColor);
            g.drawRect(Math.min(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()), Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()));
        } else {
            g.setColor(fillColor);
            g.fillRect(Math.min(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()), Math.abs(p2.getX() - p1.getX()), Math.abs(p2.getY() - p1.getY()));
        }

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
        System.out.format("erase %s\n", name);
    }

    @Override
    public boolean hit(Point p) {
        boolean b1 = Math.min(p1.getX(), p2.getX()) <= p.getX();
        boolean b2 = Math.max(p1.getX(), p2.getX()) >= p.getX();
        boolean b3 = Math.min(p1.getY(), p2.getY()) <= p.getY();
        boolean b4 = Math.max(p1.getY(), p2.getY()) >= p.getY();

        return b1 && b2 && b3 && b4;
    }
}
