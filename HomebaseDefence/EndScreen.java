/**
 * This class runs the end screen of the complete product. It displays high score and results.
 * 
 * date         20201110
 * @filename	EndScreen.java
 * @author      jdalwadi, sassareymuryil, jmajmudar, hshah, vreddy
 * @version     1.0
 * @see         assignment 4
 */

package com.homebasedefence.screen;

import java.awt.*;
import javax.swing.*;

public class EndScreen extends JFrame {
    public String result;
    public int userScore;
    public String names;
    public String name;

    /**
     * First set the values for the highscore name and score, then initialize the Components with these values
     * @param resultOutput
     * @param score
     */
    public EndScreen(String resultOutput, int score) {
        result = resultOutput;
        userScore = score;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblYourScore = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        txtYourScore = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnPlayAgain = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GAME OVER");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(150, 10, 300, 50);

        lblYourScore.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblYourScore.setForeground(new java.awt.Color(255, 255, 255));
        lblYourScore.setText("Your Score:");
        jPanel1.add(lblYourScore);
        lblYourScore.setBounds(110, 90, 110, 50);

        txtMessage.setText(String.valueOf(result));
        txtMessage.setEditable(false);
        jPanel1.add(txtMessage);
        txtMessage.setBounds(40, 170, 420, 26);

        txtYourScore.setText(String.valueOf(userScore));
        txtYourScore.setEditable(false);
        jPanel1.add(txtYourScore);
        txtYourScore.setBounds(190, 100, 120, 26);
        // Created a button called exit 
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(310, 230, 75, 29);
        // Created a button called play again
        btnPlayAgain.setText("Play Again");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlayAgain);
        btnPlayAgain.setBounds(100, 230, 97, 29);
        // Setting the background to an image 
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/background.png"))); // NOI18N
        jLabel1.setText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0,0, 500, 370);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * When the play again button is clicked it will open the game screen and close the end screen
     */
    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        GameScreen gameScreen = new GameScreen();
        gameScreen.main(new String[0]);
        dispose();
    }

    /**
     * When the exit button is clicked, it will close the entire application
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed


    public static void main(String outputResult, int score) {
        /*
        * Create and display the form
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new EndScreen(outputResult,score);
                frame.setResizable(false);
                frame.setSize(500,300);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblYourScore;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtYourScore;
    // End of variables declaration//GEN-END:variables
}
