public class Oval extends Shape {
    public Point center;
    public int axis1, axis2;

    public Oval() {
        this.center = new Point();
        this.axis1 = 1;
        this.axis2 = 1;
        this.name = "oval-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = "Black";
        this.fillColor = "White";
    }

    public Oval(Point center, int axis1, int axis2, String borderColor, String fillColor) {
        this.center = center;
        this.axis1 = axis1;
        this.axis2 = axis2;
        this.name = "oval-" + ((int) (Math.random() * 1000)); // a random id
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public void draw() { // yet just a message
        System.out.format("draw %s from %s with axis1 = %d, axis2 = %d.\n", name, center.toString(), axis1, axis2);
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
        // An advanced math formula
        double result = Math.pow((p.getX() - center.getX()), 2 / Math.pow(axis1, 2)) + Math.pow((p.getY() - center.getY()), 2) / Math.pow(axis2, 2);
        return result <= 1;
    }
}
