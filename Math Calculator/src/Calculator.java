/**
 * ICS4U
 * Brampton, Canada
 *
 * https://github.com/ayushtvora
 * https://repl.it/@TheYushinator
 *
 * modified     20200919
 * date         20200928
 * @filename    Calculator.java
 * @author      avora
 * @version     1.2
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField xField;
    private JTextField quadraticField;
    private JTextField cubicField;
    private JTextField exponentialField;
    private JTextField reciprocalField;
    private JTextField squareRootField;
    private JTextField sinField;
    private JTextField cosField;
    private JTextField absoluteField;
    private JTextField aField;
    private JTextField bField;
    private JTextField additionField;
    private JTextField subtractionField;
    private JTextField multiplicationField;
    private JTextField divisionField;
    private JTextField exponentField;
    private JTextField pythagoreanField;
    private JButton calculateButton;
    private JButton calculateButton1;
    private JPanel Panel;
    private JButton exitButton;
    private JLabel title;
    private JLabel subtitle;
    private JLabel singleInputLabel;
    private JLabel cubicLabel;
    private JLabel exponentialLabel;
    private JLabel reciprocalLabel;
    private JLabel squareRootLabel;
    private JLabel xLabel;
    private JLabel sinLabel;
    private JLabel cosLabel;
    private JLabel absoluteLabel;
    private JLabel doubleInputLabel;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel additionLabel;
    private JLabel subtractionLabel;
    private JLabel multiplicationLabel;
    private JLabel divisionLabel;
    private JLabel exponentLabel;
    private JLabel pythagoreanLabel;
    private JLabel quadraticLabel;

    double x = 0.;
    double a = 0.;
    double b = 0.;

    boolean hasError = false;

    public static double round(double y) {
        double roundedY = Math.round(y * 1000.0) / 1000.0;
        return roundedY;
    }

    public static double quadratic(double x) {
        double y = x * x;
        y = round(y);
        return y;
    }

    public static double cubic(double x) {
        double y = x * x * x;
        y = round(y);
        return y;
    }

    public static double exponential(double x) {
        double y = Math.pow(2, x);
        y = round(y);
        return y;
    }

    public static double reciprocal(double x) {
        double y = 1 / x;
        y = round(y);
        return y;
    }

    public static double squareRoot(double x) {
        double y = Math.sqrt(x);
        y = round(y);
        return y;
    }

    public static double absolute(double x) {
        double y = 0;
        if (x > 0) {
            y = x;
        } else if (x < 0) {
            y = -x;
        }
        y = round(y);
        return y;
    }

    public static double sin(double x) {
        double y = Math.sin(x);
        y = round(y);
        return y;
    }

    public static double cos(double x) {
        double y = Math.cos(x);
        y = round(y);
        return y;
    }

    public static double addition(double a, double b) {
        double y = a + b;
        y = round(y);
        return y;
    }

    public static double subtraction(double a, double b) {
        double y = a - b;
        y = round(y);
        return y;
    }

    public static double multiplication(double a, double b) {
        double y = a * b;
        y = round(y);
        return y;
    }

    public static double division(double a, double b) {
        double y = a / b;
        y = round(y);
        return y;
    }

    public static double exponent(double a, double b) {
        double y = Math.pow(a, b);
        y = round(y);
        return y;
    }

    public static double pythagorean(double a, double b) {
        double y = Math.sqrt((a * a) + (b * b));
        y = round(y);
        return y;
    }

    public static void display(JTextField field, double y) {
        String s = Double.toString(y);
        field.setText(s);
    }


    public Calculator() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    x = Double.parseDouble(xField.getText());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(Panel, "Error! Please check your input.");
                    hasError = true;
                } finally {
                    if (!hasError) {
                        display(quadraticField, quadratic(x));
                        display(cubicField, cubic(x));
                        display(exponentialField, exponential(x));
                        display(reciprocalField, reciprocal(x));
                        display(squareRootField, squareRoot(x));
                        display(absoluteField, absolute(x));
                        display(sinField, sin(x));
                        display(cosField, cos(x));
                    }
                    hasError = false;
                }
            }
        });
        calculateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    a = Double.parseDouble(aField.getText());
                    b = Double.parseDouble(bField.getText());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(Panel, "Error! Please check your inputs.");
                    hasError = true;
                } finally {
                    if (!hasError) {
                        display(additionField, addition(a, b));
                        display(subtractionField, subtraction(a, b));
                        display(multiplicationField, multiplication(a, b));
                        display(divisionField, division(a, b));
                        display(exponentField, exponent(a, b));
                        display(pythagoreanField, pythagorean(a, b));
                    }
                    hasError = false;
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyForm");
        frame.setContentPane(new Calculator().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Panel = new JPanel();
        Panel.setLayout(new GridBagLayout());
        title = new JLabel();
        title.setText("Exa-Calc");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(title, gbc);
        subtitle = new JLabel();
        subtitle.setText("The Better Calculator");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(subtitle, gbc);
        singleInputLabel = new JLabel();
        singleInputLabel.setText("Single-input functions");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(singleInputLabel, gbc);
        cubicLabel = new JLabel();
        cubicLabel.setText("y=x^3 (Cubic)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(cubicLabel, gbc);
        exponentialLabel = new JLabel();
        exponentialLabel.setText("y=2^x (Exponential)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(exponentialLabel, gbc);
        reciprocalLabel = new JLabel();
        reciprocalLabel.setText("y=1/x (Reciprocal)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(reciprocalLabel, gbc);
        squareRootLabel = new JLabel();
        squareRootLabel.setText("y=sqrt(x) (Square Root)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(squareRootLabel, gbc);
        xLabel = new JLabel();
        xLabel.setText("x (Input)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(xLabel, gbc);
        xField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(xField, gbc);
        cubicField = new JTextField();
        cubicField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(cubicField, gbc);
        exponentialField = new JTextField();
        exponentialField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(exponentialField, gbc);
        reciprocalField = new JTextField();
        reciprocalField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(reciprocalField, gbc);
        squareRootField = new JTextField();
        squareRootField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(squareRootField, gbc);
        sinLabel = new JLabel();
        sinLabel.setText("y=sin(x) (Sinusodial (Sine))");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(sinLabel, gbc);
        cosLabel = new JLabel();
        cosLabel.setText("y=cos(x) (Sinusodial(Cosine))");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(cosLabel, gbc);
        sinField = new JTextField();
        sinField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(sinField, gbc);
        cosField = new JTextField();
        cosField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(cosField, gbc);
        absoluteLabel = new JLabel();
        absoluteLabel.setText("y=|x| (Absolute)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(absoluteLabel, gbc);
        absoluteField = new JTextField();
        absoluteField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(absoluteField, gbc);
        doubleInputLabel = new JLabel();
        doubleInputLabel.setText("Dual-input functions");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(doubleInputLabel, gbc);
        aLabel = new JLabel();
        aLabel.setText("a (input 1)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(aLabel, gbc);
        additionLabel = new JLabel();
        additionLabel.setText("y=a+b (Addition)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(additionLabel, gbc);
        subtractionLabel = new JLabel();
        subtractionLabel.setText("y=a-b (Subtraction)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(subtractionLabel, gbc);
        multiplicationLabel = new JLabel();
        multiplicationLabel.setText("y=ab (Multiplicaton)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(multiplicationLabel, gbc);
        divisionLabel = new JLabel();
        divisionLabel.setText("y=a/b (Division)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(divisionLabel, gbc);
        exponentLabel = new JLabel();
        exponentLabel.setText("y=a^b (Exponent)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(exponentLabel, gbc);
        pythagoreanLabel = new JLabel();
        pythagoreanLabel.setText("a^2+b^2=y^2 (Pythagorean Theorem)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(pythagoreanLabel, gbc);
        aField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(aField, gbc);
        additionField = new JTextField();
        additionField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(additionField, gbc);
        subtractionField = new JTextField();
        subtractionField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(subtractionField, gbc);
        multiplicationField = new JTextField();
        multiplicationField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(multiplicationField, gbc);
        divisionField = new JTextField();
        divisionField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(divisionField, gbc);
        exponentField = new JTextField();
        exponentField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(exponentField, gbc);
        pythagoreanField = new JTextField();
        pythagoreanField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(pythagoreanField, gbc);
        bLabel = new JLabel();
        bLabel.setText("b (input 2)");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(bLabel, gbc);
        bField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(bField, gbc);
        calculateButton = new JButton();
        calculateButton.setText("Calculate");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(calculateButton, gbc);
        calculateButton1 = new JButton();
        calculateButton1.setText("Calculate");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(calculateButton1, gbc);
        quadraticLabel = new JLabel();
        quadraticLabel.setText("y=x^2 (Quadratic)");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(quadraticLabel, gbc);
        quadraticField = new JTextField();
        quadraticField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 100;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(quadraticField, gbc);
        exitButton = new JButton();
        exitButton.setText("Exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        Panel.add(exitButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Panel;
    }

}
