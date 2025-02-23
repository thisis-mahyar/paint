package view;

import enums.ActionType;
import enums.ShapeType;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    ShapeType currentShape = ShapeType.LINE;
    ActionType currentAction = ActionType.DRAW;

    JButton lineButton, rectangleButton, squareButton, ovalButton, circleButton, polygonButton, triangleButton;
    JCheckBox isFilledCheckBox;
    JButton eraseButton, moveButton, zoomInButton, zoomOutButton, fillColorButton, borderColorButton;

    public Menu() {
        setLayout(new GridLayout(14, 1, 10, 10));
        setPreferredSize(new Dimension(120, getHeight()));

        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rectangle");
        squareButton = new JButton("Square");
        ovalButton = new JButton("Oval");
        circleButton = new JButton("Circle");
        polygonButton = new JButton("Polygon");
        triangleButton = new JButton("Triangle");
        isFilledCheckBox = new JCheckBox("Is Filled?");
        eraseButton = new JButton("Erase");
        moveButton = new JButton("Move");
        zoomInButton = new JButton("Zoom in");
        zoomOutButton = new JButton("Zoom out");
        fillColorButton = new JButton("Fill color");
        borderColorButton = new JButton("Border color");

        add(lineButton);
        add(rectangleButton);
        add(squareButton);
        add(ovalButton);
        add(circleButton);
        add(polygonButton);
        add(triangleButton);
        add(isFilledCheckBox);
        add(eraseButton);
        add(moveButton);
        add(zoomInButton);
        add(zoomOutButton);
        add(fillColorButton);
        add(borderColorButton);

    }

}
