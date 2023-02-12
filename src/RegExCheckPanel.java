import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExCheckPanel extends JPanel {

    private JTextField regexField, stringField;
    private JLabel resultLabel;
    private JPanel contentPane;
    private JPanel inputPanel;
    private JButton matchButton;

    public RegExCheckPanel() {

        // to hold all components
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 10));
        this.setBackground(Color.DARK_GRAY);

        // for regex and string input field
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(Color.WHITE);


        contentPane.add(inputPanel, BorderLayout.NORTH);

        // add css to contentPane
        contentPane.setBackground(Color.WHITE);
        contentPane.setPreferredSize(new Dimension(360, 200));


        regexField = new JTextField(20);
        stringField = new JTextField(20);


        inputPanel.setPreferredSize(new Dimension(360, 100));
        inputPanel.add(new JLabel("Regex:"));
        inputPanel.add(new JLabel("String:"));
        inputPanel.add(regexField);
        inputPanel.add(stringField);

        matchButton = new JButton("Match");
        matchButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
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
