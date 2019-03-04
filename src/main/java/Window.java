package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * The program solution for calculating the square and perimeter of a triangle.
 * * In the window you can input 2 legs and hypotenuse for calculations.
 */
public class Window extends JFrame {
    JLabel labelHypotenuse, labelFirstLeg, labelSecondLeg;
    JFormattedTextField textFieldHypotenuse, textFieldFirstLeg, textFieldSecondLeg;
    JButton buttonAssortSquare,buttonAssortPerimeter;
    ListenerForButton listnerForButton = new ListenerForButton();
    int hypotenuse, firstLeg, secondLeg, result;

    /**
     * This is constructor. Here are components declared and
     * is called method of disposition element.
     * Set name of window.
     */
    public Window() {
        super("laba1");

        labelHypotenuse = new JLabel("Гипотенуза");
        labelHypotenuse.setOpaque(true);
        labelFirstLeg = new JLabel("1-ый катет");
        labelFirstLeg.setOpaque(true);
        labelSecondLeg = new JLabel("2-ой катет");
        labelSecondLeg.setOpaque(true);
        textFieldHypotenuse = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldFirstLeg = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textFieldSecondLeg = new JFormattedTextField(NumberFormat.getIntegerInstance());
        buttonAssortSquare = new JButton("Площадь");
        buttonAssortPerimeter = new JButton("Периметр");

        buttonAssortSquare.addActionListener(listnerForButton);
        buttonAssortPerimeter.addActionListener(listnerForButton);
    }

    /**
     * This method implements dispositions on the window
     * using HorizontalBox and VerticalBox.
     */
    public void dispositionElement(Container pane) {

        GridBagLayout gridBagLayout = new GridBagLayout();

        pane.setLayout(gridBagLayout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.weightx = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        pane.add(labelHypotenuse, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        pane.add(textFieldHypotenuse, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        pane.add(labelFirstLeg, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        pane.add(textFieldFirstLeg, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        pane.add(labelSecondLeg, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        pane.add(textFieldSecondLeg, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        //buttonAssortPerimeter.setSize(20,20);
        pane.add(buttonAssortSquare, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        //buttonAssortPerimeter.setSize(20,20);
        pane.add(buttonAssortPerimeter, constraints);
    }

    /**
     * This class use for handling  button.
     */
    public class ListenerForButton implements ActionListener {
        /**
         * This method for processing press button.
         *
         * @param e is the action event.
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonAssortSquare) {
                if (textFieldHypotenuse.getValue() == null ||
                        textFieldFirstLeg.getValue() == null ||
                        textFieldSecondLeg.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Заполните поля",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                } else {
                    hypotenuse = Integer.parseInt(textFieldHypotenuse.getValue().toString());
                    firstLeg = Integer.parseInt(textFieldFirstLeg.getValue().toString());
                    secondLeg = Integer.parseInt(textFieldSecondLeg.getValue().toString());

                    result = (firstLeg * secondLeg)/2;
                    labelHypotenuse.setBackground(Color.lightGray);
                    labelFirstLeg.setBackground(Color.cyan);
                    labelSecondLeg.setBackground(Color.cyan);
                    String root = "Площадь = " + result;
                    buttonAssortSquare.setText(root);
                }
            }
            if (e.getSource() == buttonAssortPerimeter){
                if (textFieldHypotenuse.getValue() == null ||
                        textFieldFirstLeg.getValue() == null ||
                        textFieldSecondLeg.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Заполните поля",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }else {
                    hypotenuse = Integer.parseInt(textFieldHypotenuse.getValue().toString());
                    firstLeg = Integer.parseInt(textFieldFirstLeg.getValue().toString());
                    secondLeg = Integer.parseInt(textFieldSecondLeg.getValue().toString());

                    result = firstLeg + secondLeg + hypotenuse;
                    labelHypotenuse.setBackground(Color.cyan);
                    labelFirstLeg.setBackground(Color.cyan);
                    labelSecondLeg.setBackground(Color.cyan);
                    String root = "Периметр = " + result;
                    buttonAssortPerimeter.setText(root);
                }
            }
        }
    }
}
