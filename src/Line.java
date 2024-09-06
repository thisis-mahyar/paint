public class Line {
    public Point p1, p2;
    public String name;
    public String borderColor;

    public Line() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.name = "line-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = "Black";
    }

    public Line(Point p1, Point p2, String borderColor) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = "line-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
    }
}