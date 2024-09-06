import java.util.Arrays;

public class PaintingArea {
    public Shape[] shapeArr;

    public PaintingArea() {
        shapeArr = new Shape[0];
    }

    public void addShape(Shape s) {
        shapeArr = Arrays.copyOf(shapeArr, shapeArr.length + 1);
        shapeArr[shapeArr.length - 1] = s;

        s.draw();
    }

    public boolean removeShape(int index) {
        if (0 <= index && index < shapeArr.length) {
            for (int i = index; i < shapeArr.length - 1; i++) // shift
                shapeArr[i] = shapeArr[i + 1];

            shapeArr = Arrays.copyOf(shapeArr, shapeArr.length - 1);

            return true;
        }

        return false;
    }

    public int indexOfLine(Shape s) {
        for (int i = 0; i < shapeArr.length; i++)
            if (shapeArr[i] == s)
                return i;

        return -1;
    }

    public Shape getShapeByPoint(Point p) {
        for (Shape s : shapeArr)
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

        for (Shape s : shapeArr) {
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
