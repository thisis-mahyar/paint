package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends Polygon {
    public Triangle() {
        this.points = new ArrayList<>(3);
        this.name = "triangle-" + ((int) (Math.random() * 1000)); // a random id
    }

    public Triangle(Point p1, Point p2, Point p3, Color borderColor, Color fillColor) {
        this.points.set(0, p1);
        this.points.set(1, p2);
        this.points.set(2, p3);
        this.name = "triangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public void draw(Graphics g) { // yet just a message
        System.out.format("draw %s with points: %s, %s, %s.\n", name, points.get(0).toString(), points.get(1).toString(), points.get(2).toString());
    }
}
