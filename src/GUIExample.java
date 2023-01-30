import javax.swing.*;
import java.awt.*;

public class GUIExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel regExInfo=new JLabel("hello");

        // Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.red);
        leftPanel.setPreferredSize(new Dimension(600,700));
        leftPanel.add(regExInfo);
        // Right panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(600,700));

        // Top panel
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);

        JTextField textField = new JTextField(10);
        JButton button = new JButton("Submit");
        topPanel.add(textField);
        topPanel.add(button);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("Welcome @mahmutunder");
        label.setForeground(Color.WHITE);
        bottomPanel.add(label);

        rightPanel.add(topPanel, BorderLayout.NORTH);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
