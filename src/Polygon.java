import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygon extends Shape {
    public List<Point> points;

    public Polygon() {
        this.points = new ArrayList<>();
        this.name = "polygon-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;
    }

    public Polygon(List<Point> points, Color borderColor, Color fillColor) {
        this.points = points;
        this.name = "polygon-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];

        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = points.get(i).getX();
            yPoints[i] = points.get(i).getY();
        }

        if (!isFilled) {
            g.setColor(borderColor);
            g.drawPolygon(xPoints, yPoints, points.size());
        } else {
            g.setColor(fillColor);
            g.drawPolygon(xPoints, yPoints, points.size());
        }

        System.out.format("draw %s with %d points.\n", name, points.size());
    }

    @Override
    public void move(int xMove, int yMove) {
        for (Point point : points) {
            point.setX(point.getX() + xMove);
            point.setY(point.getY() + yMove);
        }
    }

    @Override
    public void erase() { // yet just a message
        System.out.format("erase %s\n", name);
    }

    @Override
    public boolean hit(Point p) {
        // an advanced math formula

        int xMin = points.get(0).getX();
        int xMax = points.get(0).getX();
        int yMin = points.get(0).getY();
        int yMax = points.get(0).getY();

        for (Point pp : points) {
            xMin = Math.min(xMin, pp.getX());
            xMax = Math.max(xMax, pp.getX());
            yMin = Math.min(yMin, pp.getY());
            yMax = Math.max(yMax, pp.getY());
        }

        return p.getX() <= xMax && p.getX() >= xMin && p.getY() >= yMin && p.getY() <= yMax;
    }
}
