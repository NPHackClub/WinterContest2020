/**
 * ICS4U
 * Brampton, Canada
 *
 * https://github.com/ayushtvora
 * https://repl.it/@TheYushinator
 *
 * date         20200925
 * @filename    TicTacToe.java
 * @author      avora
 * @version     1.0
 * @see         Tic Tac Toe game created in JSwing. Full documentation provided.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class. Running it will start the game.
 */
public class TicTacToe {
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton c1;
    private JButton c2;
    private JButton c3;
    private JButton c4;
    private JButton d1;
    private JButton d2;
    private JButton d3;
    private JButton d4;
    private JTextField xWinsTextField;
    private JTextField oWinsTextField;
    private JButton resetGameButton;
    private JButton exitButton;
    private JPanel myPanel;
    private JTextField tieWinsTextField;
    /**
     * Define variables.
     */
    String path = "./";
    // imgs by: https://tenor.com/view/letter-x-gif-9063768 and https://tenor.com/view/letter-gif-9063759
    ImageIcon xImg = new ImageIcon(path + "x.gif");
    ImageIcon oImg = new ImageIcon(path + "o.gif");
    //img by: https://proofthatblog.com/2013/07/01/the-question-is-what-happened-to-the-question-mark/
    ImageIcon qMarkImg = new ImageIcon(path + "qMark.jpg");
    int clicks = 0;
    boolean win = false;
    int xWinCount = 0;
    int oWinCount = 0;
    int tieCount = 0;
    int[][] check = new int[4][4];

    /**
     * Runs when user presses a button to play their turn.
     *
     * @param b The button that was clicked.
     * @param x The location of the button from the left (starting at 0). Used for the check array.
     * @param y The location of the button from the top (starting at 0). Used for the check array.
     */
    public void playerMove(JButton b, int x, int y) {
        if (check[x][y] == 0) {
            clicks++;
            if (clicks % 2 == 1) {
                b.setIcon(xImg);
                check[x][y] = 1;
            } else {
                b.setIcon(oImg);
                check[x][y] = 2;
            }
            winner();
        } else {
            JOptionPane.showMessageDialog(myPanel, "Error! This one has already been placed. Please try again.");
        }
    }

    /**
     * Runs when previous round has concluded. Resets the playing field. Does not restart score.
     */
    public void newRound() {
        clicks = 0;
        win = false;
        a1.setIcon(qMarkImg);
        a2.setIcon(qMarkImg);
        a3.setIcon(qMarkImg);
        a4.setIcon(qMarkImg);
        b1.setIcon(qMarkImg);
        b2.setIcon(qMarkImg);
        b3.setIcon(qMarkImg);
        b4.setIcon(qMarkImg);
        c1.setIcon(qMarkImg);
        c2.setIcon(qMarkImg);
        c3.setIcon(qMarkImg);
        c4.setIcon(qMarkImg);
        d1.setIcon(qMarkImg);
        d2.setIcon(qMarkImg);
        d3.setIcon(qMarkImg);
        d4.setIcon(qMarkImg);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                check[i][j] = 0;
            }
        }
    }

    /**
     * Runs on click of the Reset button. Resets the game, resetting the round and score.
     */
    public void resetGame() {
        newRound();
        xWinCount = 0;
        oWinCount = 0;
        tieCount = 0;
        xWinsTextField.setText("X Wins: 0");
        oWinsTextField.setText("Y Wins: 0");
        tieWinsTextField.setText("Question Mark Man Wins: 0");
    }

    /**
     * Runs when X wins the round. Updates scoreboard and starts a new round.
     */
    public void xWins() {
        win = true;
        xWinCount++;
        xWinsTextField.setText("X Wins: " + xWinCount);
        JOptionPane.showMessageDialog(myPanel, "X wins!");
        newRound();
    }

    /**
     * Runs when O wins the round. Updates scoreboard and starts a new round.
     */
    public void oWins() {
        win = true;
        oWinCount++;
        oWinsTextField.setText("O Wins: " + oWinCount);
        JOptionPane.showMessageDialog(myPanel, "O wins!");
        newRound();
    }

    /**
     * Runs when the round ends in a tie. Updates scoreboard and starts a new round.
     */
    public void tieWins() {
        win = true;
        tieCount++;
        tieWinsTextField.setText("Question Mark Man Wins: " + tieCount);
        JOptionPane.showMessageDialog(myPanel, "Tie Game!");
        newRound();
    }


    /**
     * Defines who wins the round.
     */
    public void winner() {
        for (int i = 0; i < 4; i++) {
            // Win by row
            if ((check[i][0] == check[i][1]) && (check[i][0] == check[i][2]) && (check[i][0] == check[i][3])) {
                if (check[i][0] == 1) {
                    xWins();
                } else if (check[i][0] == 2) {
                    oWins();
                }
            }
            // Win by column
            if ((check[0][i] == check[1][i]) && (check[0][i] == check[2][i]) && (check[0][i] == check[3][i])) {
                if (check[0][i] == 1) {
                    xWins();
                } else if (check[0][i] == 2) {
                    oWins();
                }
            }
        }
        // Win my diagonal (top to bottom)
        if ((check[0][0] == check[1][1]) && (check[0][0] == check[2][2]) && (check[0][0] == check[3][3])) {
            if (check[0][0] == 1) {
                xWins();
            } else if (check[0][0] == 2) {
                oWins();
            }
        }
        // Win by diagonal (bottom to top)
        if ((check[0][3] == check[1][2]) && (check[0][3] == check[2][1]) && (check[0][3] == check[3][0])) {
            if (check[0][3] == 1) {
                xWins();
            } else if (check[0][3] == 2) {
                oWins();
            }
        }
        // Tie game
        if (clicks == 16 && win == false) {
            tieWins();
        }
    }

    /**
     * Action listeners for every button in the GUI.
     */
    public TicTacToe() {
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(a1, 0, 0);
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(a2, 0, 1);
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(a3, 0, 2);
            }
        });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(a4, 0, 3);
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(b1, 1, 0);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(b2, 1, 1);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(b3, 1, 2);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(b4, 1, 3);
            }
        });
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(c1, 2, 0);
            }
        });
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(c2, 2, 1);
            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(c3, 2, 2);
            }
        });
        c4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(c4, 2, 3);
            }
        });
        d1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(d1, 3, 0);
            }
        });
        d2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(d2, 3, 1);
            }
        });
        d3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(d3, 3, 2);
            }
        });
        d4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerMove(d4, 3, 3);
            }
        });
        resetGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
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
        frame.setContentPane(new TicTacToe().myPanel);
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
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        Font label1Font = this.$$$getFont$$$(null, -1, 24, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Ayush Tic Tac Toe");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        myPanel.add(label1, gbc);
        a1 = new JButton();
        a1.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        a1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(a1, gbc);
        a2 = new JButton();
        a2.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        a2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(a2, gbc);
        a3 = new JButton();
        a3.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        a3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(a3, gbc);
        a4 = new JButton();
        a4.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        a4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(a4, gbc);
        b1 = new JButton();
        b1.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        b1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(b1, gbc);
        b2 = new JButton();
        b2.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        b2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(b2, gbc);
        b3 = new JButton();
        b3.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        b3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(b3, gbc);
        b4 = new JButton();
        b4.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        b4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(b4, gbc);
        c1 = new JButton();
        c1.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        c1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(c1, gbc);
        c2 = new JButton();
        c2.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        c2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(c2, gbc);
        c3 = new JButton();
        c3.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        c3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(c3, gbc);
        c4 = new JButton();
        c4.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        c4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(c4, gbc);
        d1 = new JButton();
        d1.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        d1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(d1, gbc);
        d2 = new JButton();
        d2.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        d2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(d2, gbc);
        d3 = new JButton();
        d3.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        d3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(d3, gbc);
        d4 = new JButton();
        d4.setIcon(new ImageIcon(getClass().getResource("/qMark.jpg")));
        d4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myPanel.add(d4, gbc);
        xWinsTextField = new JTextField();
        xWinsTextField.setEditable(false);
        xWinsTextField.setText("X Wins: 0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        myPanel.add(xWinsTextField, gbc);
        oWinsTextField = new JTextField();
        oWinsTextField.setEditable(false);
        oWinsTextField.setText("O Wins: 0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        myPanel.add(oWinsTextField, gbc);
        exitButton = new JButton();
        exitButton.setText("Exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        myPanel.add(exitButton, gbc);
        resetGameButton = new JButton();
        resetGameButton.setText("Reset Game");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        myPanel.add(resetGameButton, gbc);
        tieWinsTextField = new JTextField();
        tieWinsTextField.setEditable(false);
        tieWinsTextField.setText("Question Mark Man Wins: 0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        myPanel.add(tieWinsTextField, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return myPanel;
    }
}
