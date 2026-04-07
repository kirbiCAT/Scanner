package org.example;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.green);
    }
    JLabel label = new JLabel();
    JFrame frame = new JFrame();
    //frame.add(label);
}
