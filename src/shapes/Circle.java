package shapes;

import java.awt.*;

public class Circle extends Oval {
    public Circle() {
        this.center = new Point();
        this.axis1 = 1;
        this.axis2 = 2;
        this.name = "circle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;
    }

    public Circle(Point center, int radius, Color borderColor, Color fillColor) {
        this.center = center;
        this.axis1 = radius;
        this.axis2 = radius;
        this.name = "circle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
}
