import java.util.Arrays;

public class PaintingArea {
    public Line[] lineArr;
    public Rectangle[] rectArr;
    public Circle[] circleArr;

    public PaintingArea() {
        lineArr = new Line[0];
        rectArr = new Rectangle[0];
        circleArr = new Circle[0];
    }

    public void addLine(Line l) {
        lineArr = Arrays.copyOf(lineArr, lineArr.length + 1);
        lineArr[lineArr.length - 1] = l;
        l.draw();
    }

    public void addCircle(Circle c) {
        circleArr = Arrays.copyOf(circleArr, circleArr.length + 1);
        circleArr[circleArr.length - 1] = c;
        c.draw();
    }

    public void addRectangle(Rectangle r) {
        rectArr = Arrays.copyOf(rectArr, rectArr.length + 1);
        rectArr[rectArr.length - 1] = r;
        r.draw();
    }

    public boolean removeLine(int index) {
        if (0 <= index && index < lineArr.length) {
            for (int i = index; i < lineArr.length - 1; i++) // shift
                lineArr[i] = lineArr[i + 1];

            lineArr = Arrays.copyOf(lineArr, lineArr.length - 1);

            return true;
        }

        return false;
    }

    public boolean removeCircle(int index) {
        if (0 <= index && index < lineArr.length) {
            for (int i = index; i < circleArr.length - 1; i++) // shift
                circleArr[i] = circleArr[i + 1];

            circleArr = Arrays.copyOf(circleArr, circleArr.length - 1);

            return true;
        }

        return false;
    }

    public boolean removeRectangle(int index) {
        if (0 <= index && index < lineArr.length) {
            for (int i = index; i < rectArr.length - 1; i++) // shift
                rectArr[i] = rectArr[i + 1];

            rectArr = Arrays.copyOf(rectArr, rectArr.length - 1);

            return true;
        }

        return false;
    }

    public int indexOfLine(Line l) {
        for (int i = 0; i < lineArr.length; i++)
            if (lineArr[i] == l)
                return i;

        return -1;
    }

    public int indexOfCircle(Circle c) {
        for (int i = 0; i < circleArr.length; i++)
            if (circleArr[i] == c)
                return i;

        return -1;
    }

    public int indexOfRectangle(Rectangle r) {
        for (int i = 0; i < rectArr.length; i++)
            if (rectArr[i] == r)
                return i;

        return -1;
    }
}
