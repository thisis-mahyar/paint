package shapes;

import java.awt.*;

public class Square extends Rectangle {
    public Square() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.name = "square-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;
    }

    public Square(Point p1, Point p2, Color borderColor, Color fillColor) {
        this.p1 = p1;
        this.p2 = p2;
        makeSidesEqual(p1, p2);
        this.name = "square-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    private void makeSidesEqual(Point p1, Point p2) {
        int dX = p2.getX() - p1.getX();
        int dY = p2.getY() - p1.getY();

        if (Math.abs(dX) > Math.abs(dY))
            p2.setY(p1.getY() + (int) Math.signum(dY) * Math.abs(dX));
        else
            p2.setX(p1.getX() + (int) Math.signum(dX) * Math.abs(dY));
    }
}
