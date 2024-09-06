public class Shape {
    public String name;
    public String borderColor;
    public String fillColor;
    public boolean isFilled;

    public Shape() {
        this.borderColor = "Black";
        this.fillColor = "White";
        this.isFilled = false;
    }

    public Shape(String borderColor, String fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.isFilled = false;
    }

    public void draw() {
    }

    public void move(int xMove, int yMove) {
    }

    public void erase() {
    }

    public boolean hit(Point p) {
        return false;
    }
}
