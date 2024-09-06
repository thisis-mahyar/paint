import java.awt.*;
import java.util.Scanner;
import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        PaintingArea paintingArea = new PaintingArea();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many shapes? ");
        int shapeCount = scanner.nextInt();

        for (int i = 0; i < shapeCount; i++) {
            Shape s = null;
            int r = (int) (random() * 3);

            if (r == 0)
                s = new Line(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), Color.BLACK);
            else if (r == 1)
                s = new Circle(new Point((int) (random() * 500), (int) (random() * 500)), (int) (random() * 100), Color.BLACK, Color.YELLOW);
            else if (r == 2)
                s = new Rectangle(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), Color.BLACK, Color.MAGENTA);

            paintingArea.addShape(s);
        }
        
        paintingArea.status();
    }
}
