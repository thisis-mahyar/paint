public class Circle extends Shape {
    public Point center;
    public int radius;

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

    @Override
    public void draw() { // yet just a message
        System.out.format("draw %s from %s with radius = %d.\n", name, center.toString(), radius);
    }

    @Override
    public void move(int xMove, int yMove) {
        center.setX(center.getX() + xMove);
        center.setY(center.getY() + yMove);
    }

    @Override
    public void erase() { // yet just a message
        System.out.format("erase %s.\n", name);
    }

    @Override
    public boolean hit(Point p) {
        return center.distance(p) <= radius;
    }
}
