package shapes;

import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JComponent {
    public String name;
    public Color borderColor;
    public Color fillColor;
    public boolean isFilled;

    public Shape() {
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;
        this.isFilled = false;
    }

    public Shape(Color borderColor, Color fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.isFilled = false;
    }

    public abstract void draw(Graphics g);

    public abstract void move(int xMove, int yMove);

    public abstract void erase();

    public abstract boolean hit(Point p);
}
