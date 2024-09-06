import java.util.Scanner;
import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        PaintingArea paintingArea = new PaintingArea();
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many shapes? ");
        int shapeCount = scanner.nextInt();

        for (int i = 0; i < shapeCount; i++) {
            switch ((int) (random() * 3)) {
                case 0 -> {
                    Line l = new Line(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), "Black");
                    paintingArea.addLine(l);
                }
                case 1 -> {
                    Circle c = new Circle(new Point((int) (random() * 500), (int) (random() * 500)), (int) (random() * 100), "Black", "Yellow");
                    paintingArea.addCircle(c);
                }
                case 2 -> {
                    Rectangle r = new Rectangle(new Point((int) (random() * 1000), (int) (random() * 1000)), new Point((int) (random() * 1000), (int) (random() * 1000)), "Black", "Violet");
                    paintingArea.addRectangle(r);
                }
            }
        }
        
        paintingArea.status();
    }
}
