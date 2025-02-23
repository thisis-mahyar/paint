package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends Polygon {
    public Triangle() {
        this.points = new ArrayList<>();
        this.name = "triangle-" + ((int) (Math.random() * 1000)); // a random id
    }

    public Triangle(Point p1, Point p2, Point p3, Color borderColor, Color fillColor) {
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
        this.name = "triangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
}
