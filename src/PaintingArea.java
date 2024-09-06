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
}
