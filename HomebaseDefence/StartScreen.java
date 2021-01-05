/**
 * This class runs the start screen of the complete product. It displays a welcome page, shows instructions, and asks if the player would like to play the game or not.
 * 
 * date         20201110
 * @filename	StartScreen.java
 * @author      jdalwadi, sassareymuryil, jmajmudar, hshah, vreddy
 * @version     1.0
 * @see         assignment 4
 */

package com.homebasedefence.screen;


import java.awt.*;
import javax.swing.*;
public class StartScreen extends javax.swing.JFrame {

    public StartScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        instruct = new javax.swing.JLabel();
        goal = new javax.swing.JLabel();
        match = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        notMatched = new javax.swing.JLabel();
        health = new javax.swing.JLabel();
        gameOver = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        groupName = new javax.swing.JLabel();
        imageBack = new javax.swing.JLabel();
        ImageIcon back = new ImageIcon("./Assets/Images/background.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        //learned how to stack labels on netbeans gui from here
        //https://www.youtube.com/watch?v=hIZyJzP96Pg
        jPanel1.setLayout(null);

        title.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Homebase Defence");
        jPanel1.add(title);
        title.setBounds(210, 0, 350, 70);

        instruct.setFont(new java.awt.Font("Helvetica Neue", 0, 26)); // NOI18N
        instruct.setForeground(new java.awt.Color(255, 255, 255));
        instruct.setText("How to Play?");
        jPanel1.add(instruct);
        instruct.setBounds(20, 70, 160, 30);

        goal.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        goal.setForeground(new java.awt.Color(255, 255, 255));
        goal.setText("* The goal of the game is to destroy as many asteroids as possible to defend your Homebase!");
        jPanel1.add(goal);
        goal.setBounds(20, 120, 670, 20);

        match.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        match.setForeground(new java.awt.Color(255, 255, 255));
        match.setText("* Match the pattern at the bottom of the screen to destory an asteroid.");
        jPanel1.add(match);
        match.setBounds(20, 130, 670, 60);
        
        points.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        points.setForeground(new java.awt.Color(255, 255, 255));
        points.setText("* Each broken asteroid is worth 5 points. In the next round, each asteroid destroyed is worth 5 more points.");
        jPanel1.add(points);
        points.setBounds(20, 160, 700, 60);

        notMatched.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        notMatched.setForeground(new java.awt.Color(255, 255, 255));
        notMatched.setText("* If you fail to match the pattern, asteroids move one step closer to your Homebase.");
        jPanel1.add(notMatched);
        notMatched.setBounds(20, 190, 670, 60);

        health.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        health.setForeground(new java.awt.Color(255, 255, 255));
        health.setText("* Each time an asteroid hits your Homebase, you will lose health.");
        jPanel1.add(health);
        health.setBounds(20, 220, 670, 60);

        gameOver.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        gameOver.setForeground(new java.awt.Color(255, 255, 255));
        gameOver.setText("* If you have no health remaining, the game is over.");
        jPanel1.add(gameOver);
        gameOver.setBounds(20, 250, 670, 60);

        groupName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        groupName.setForeground(new java.awt.Color(255, 255, 255));
        groupName.setText("GROUP 4 - Jaimil, Sam, Harsh, Vinay, and Jainil");
        jPanel1.add(groupName);
        groupName.setBounds(20, 315, 670, 60);

        // creating a button called Play Game
        btnPlay.setText("Play Game");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay);
        btnPlay.setBounds(480, 330, 97, 29);

        // creating a butoon called Exit
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(580, 330, 97, 29);

        // setting background of pane to an image
        imageBack.setIcon(back); // NOI18N
        jPanel1.add(imageBack);
        imageBack.setBounds(0, -12, 740, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * setting the action of the exit button to close application when pressed
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }    

    /** 
     * setting the action of the play game button to open game screen and close the start screen when pressed
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {  
        //learned to set up the call from here
        //https://stackoverflow.com/questions/2550310/can-a-main-method-of-class-be-invoked-from-another-class-in-java
        GameScreen gameScreen = new GameScreen();
        //learned to call main method with string[] args parameter from another class from this website
        //https://stackoverflow.com/questions/4122455/is-it-possible-to-call-the-main-method-passing-args-from-another-method
        gameScreen.main(new String[0]);
        //learned an alternate to System.exit(0); to close website from here
        //https://stackoverflow.com/questions/28908262/how-do-you-close-a-java-gui-without-ending-the-jvm/28908292
        dispose();
    }                                    


    public static void main(String[]args) {
        /**
        * Create and display the form
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new StartScreen();
                frame.setResizable(false);
                frame.setSize(735,395);
                frame.setVisible(true);
            }
        });
    }
                  
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel gameOver;
    private javax.swing.JLabel goal;
    private javax.swing.JLabel health;
    private javax.swing.JLabel imageBack;
    private javax.swing.JLabel instruct;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel match;
    private javax.swing.JLabel notMatched;
    private javax.swing.JLabel points;
    private javax.swing.JLabel title;
    private javax.swing.JLabel groupName;
    // End of variables declaration                   
}

