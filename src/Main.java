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

            if (random() * 3 == 0)
                s = new Line(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), "Black");
            else if (random() * 3 == 1)
                s = new Circle(new Point((int) (random() * 500), (int) (random() * 500)), (int) (random() * 100), "Black", "Yellow");
            else if (random() * 3 == 2)
                s = new Rectangle(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), "Black", "Violet");

            paintingArea.addShape(s);
        }
        
        paintingArea.status();
    }
}
