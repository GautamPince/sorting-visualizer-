package main;

import java.awt.Color;

// import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainLogin {
    public static final int SCREEN_WIDTH = 1080;
    public static final int SCREEN_HEIGHT = SCREEN_WIDTH * 9 / 16;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setBackground(Color.gray);
                frame.setContentPane(new LoginPanel());
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
