public abstract class Shape {
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

    public abstract void draw();

    public abstract void move(int xMove, int yMove);

    public abstract void erase();

    public abstract boolean hit(Point p);
}
