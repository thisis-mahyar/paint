import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintingArea {
    List<Shape> shapeList;
    Graphics g;
    int width, height;

    public PaintingArea(Graphics g, int width, int height) {
        shapeList = new ArrayList<>();
        this.g = g;
        this.width = width;
        this.height = height;
    }

    public void addShape(Shape s) {
        shapeList.add(s);
        s.draw(g);
    }

    public boolean removeShape(int index) {
        if (0 <= index && index < shapeList.size())
            if (shapeList.remove(index) != null) // if the shape exists
                return true;

        return false;
    }

    public int indexOfLine(Shape s) {
        return shapeList.indexOf(s);
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

    public void status() {
        int lines = 0;
        int circles = 0;
        int rectangles = 0;
        int ovals = 0;
        int squares = 0;
        int polygons = 0;
        int triangles = 0;

        for (Shape s : shapeList) {
            if (s instanceof Line) {
                lines++;
            } else if (s instanceof Oval) {
                if (s instanceof Circle)
                    circles++;
                else
                    ovals++;
            } else if (s instanceof Rectangle) {
                if (s instanceof Square)
                    squares++;
                else
                    rectangles++;
            } else if (s instanceof Polygon) {
                if (s instanceof Triangle)
                    triangles++;
                else
                    polygons++;
            }
        }

        System.out.format("# lines      = %d\n", lines);
        System.out.format("# ovals      = %d\n", ovals);
        System.out.format("# circles    = %d\n", circles);
        System.out.format("# rectangles = %d\n", rectangles);
        System.out.format("# squares    = %d\n", squares);
        System.out.format("# polygons   = %d\n", polygons);
        System.out.format("# triangles  = %d\n", triangles);
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
