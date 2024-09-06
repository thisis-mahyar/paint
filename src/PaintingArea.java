import java.util.ArrayList;
import java.util.List;

public class PaintingArea {
    List<Shape> shapeList;

    public PaintingArea() {
        shapeList = new ArrayList<>();
    }

    public void addShape(Shape s) {
        shapeList.add(s);
        s.draw();
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

        if (s != null)
            s.move(xMove, yMove);
    }

    public void status() {
        int lCount = 0, cCount = 0, rCount = 0;

        for (Shape s : shapeList) {
            if (s instanceof Line)
                lCount++;
            else if (s instanceof Circle)
                cCount++;
            else if (s instanceof Rectangle)
                rCount++;
        }

        System.out.format("Line = %d, Circle = %d, Rectangle = %d\n", lCount, cCount, rCount);
    }
}
