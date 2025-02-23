package view;

import enums.ActionType;
import enums.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    Point p1, p2, p3;
    Color borderColor, fillColor;

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

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.LINE;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.RECTANGLE;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.SQUARE;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        ovalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.OVAL;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.CIRCLE;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        polygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.POLYGON;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = ShapeType.TRIANGLE;
                currentAction = ActionType.DRAW;
                p1 = p2 = p3 = null;
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAction = ActionType.ERASE;
                p1 = p2 = p3 = null;
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAction = ActionType.MOVE;
                p1 = p2 = p3 = null;
            }
        });

        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAction = ActionType.ZOOM_IN;
                p1 = p2 = p3 = null;
            }
        });

        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAction = ActionType.ZOOM_OUT;
                p1 = p2 = p3 = null;
            }
        });

        fillColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFillColor(); // must be passed as a method, otherwise "this" wouldn't point to Form
            }
        });

        borderColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseBorderColor(); // must be passed as a method, otherwise "this" wouldn't point to Form
            }
        });

        setVisible(true);
    }

    private void chooseFillColor() {
        fillColor = JColorChooser.showDialog(this, "Select fill color", fillColor);
    }

    private void chooseBorderColor() {
        borderColor = JColorChooser.showDialog(this, "Select border color", borderColor);
    }
}
