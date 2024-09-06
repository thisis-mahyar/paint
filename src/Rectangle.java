public class Rectangle {
    public Point p1, p2;
    public String name;
    public String borderColor;
    public String fillColor;

    public Rectangle() {
        this.p1 = new Point();
        this.p2 = new Point();
        this.name = "rectangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = "Black";
        this.fillColor = "White";
    }

    public Rectangle(Point p1, Point p2, String borderColor, String fillColor) {
        this.p1 = p1;
        this.p2 = p2;
        this.name = "rectangle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
}
