
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoginPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final int SCREEN_WIDTH = 1080;
    public static final int SCREEN_HEIGHT = SCREEN_WIDTH * 9 / 16;

    public LoginPanel() {
        setLayout(null); // Use absolute layout
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));

        // Heading
        JLabel heading = new JLabel("Sorting Visualizer - Login", JLabel.CENTER);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(12, 10, 230));
        heading.setBounds((SCREEN_WIDTH) / 2 - 300, 50, 600, 45);
        add(heading);

        // Rules
        String[] rules = {
                "1. Click the button to start the main application.",
                "2. Follow the on-screen instructions.",
                "3. First, shuffle the array by clicking the shuffle button.",
                "4. Press the burger button to select the sorting algorithm.",
                "5. Press the play button to start the sorting algorithm.",
                "6. Enjoy exploring sorting algorithms!"
        };

        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
        rulesPanel.setBackground(Color.gray);
        rulesPanel.setBounds((SCREEN_WIDTH) / 2 - 300, 150, 600, 300);
        StringBuilder rulesText = new StringBuilder("<html><div style='color:rgb(80, 10, 200); font-size: 16px;'>");
        for (String rule : rules) {
            rulesText.append(rule).append("<br>");
        }
        rulesText.append("</div></html>");
        JLabel rulesLabel = new JLabel(rulesText.toString(), JLabel.CENTER);

        rulesPanel.add(rulesLabel, BorderLayout.CENTER);

        add(rulesPanel);

        // Start Button
        JButton startButton = new JButton("Start Main Application");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setBackground(new Color(12, 10, 230));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusable(false);
        startButton.setBounds(SCREEN_WIDTH / 2 - 160, SCREEN_HEIGHT - 100, 320, 40); // Centered horizontally, 40px
                                                                                     // tall, 120px wide
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMainApp();
            }
        });
        add(startButton);
        setBackground(Color.GRAY);
    }

    private void startMainApp() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp().start();
            }
        });
    }
}
