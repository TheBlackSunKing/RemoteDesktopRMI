/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.student.javasimplermi;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
//import view.ServerView;
import view.WelcomeView;
/**
 *
 * @author Usuario
 */
public class JavaSimpleRMI {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater
        (() -> {
            JFrame frame = new JFrame();
            
            JPanel welcomeView = new WelcomeView(frame);
            //JPanel serverView = new ServerView(frame);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(welcomeView);
            frame.setSize(600,400);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            //frame.getContentPane().add(serverView);
            //frame.getContentPane().add(serverView, "serverView");
            frame.pack();
            frame.setVisible(true);
        });

    }
}
