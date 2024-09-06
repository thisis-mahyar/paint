public class Circle {
    public Point center;
    public int radius;
    public String name;
    public String borderColor;
    public String fillColor;

    public Circle() {
        this.center = new Point();
        this.radius = 1;
        this.name = "circle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = "Black";
        this.fillColor = "White";
    }

    public Circle(Point center, int radius, String borderColor, String fillColor) {
        this.center = center;
        this.radius = radius;
        this.name = "circle-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
}
