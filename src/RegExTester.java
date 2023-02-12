import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegExTester extends JPanel {

    private JTextField regexField, stringField;
    private JLabel resultLabel;
    private JPanel contentPane;
    private JPanel inputPanel;
    private JButton matchButton;

    public RegExTester() {

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 10));

        this.setBackground(Color.DARK_GRAY);

       inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        contentPane.add(inputPanel, BorderLayout.NORTH);

        contentPane.setBackground(Color.WHITE);
        contentPane.setPreferredSize(new Dimension(360,200));

        inputPanel.add(new JLabel("Regex:"));
        regexField = new JTextField(10);
        inputPanel.add(regexField);

        inputPanel.setPreferredSize(new Dimension(360,100));
        inputPanel.add(new JLabel("String:"));
        stringField = new JTextField(10);
        inputPanel.add(stringField);

         matchButton = new JButton("Match");
         matchButton.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        matchButton.addActionListener(e -> match());
        contentPane.add(matchButton, BorderLayout.SOUTH);

        resultLabel = new JLabel();
        contentPane.add(resultLabel, BorderLayout.CENTER);
        this.add(contentPane);
    }

    private void match() {
        String regex = regexField.getText();
        String string = stringField.getText();
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(string);
            if (matcher.matches()) {
                resultLabel.setText("Match");
            } else {
                resultLabel.setText("Does not match");
            }
        } catch (Exception e) {
            resultLabel.setText("Invalid regex");
        }
    }

}
