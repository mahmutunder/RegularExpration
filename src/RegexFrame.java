import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class RegexFrame {

    private static RegExCheckPanel tester;

    private static File regexFile=new File("regex.txt");
    private static Scanner scanner;
    private static String regexInfo;

    static {
        tester= new RegExCheckPanel();
        try {
            scanner = new Scanner(regexFile);

            regexInfo="<html>";
            while (scanner.hasNext()){
                String regex =scanner.nextLine();
                regexInfo+="    "+regex+"<br>";
            }
            regexInfo+="</html>";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private JFrame frame;
    private JLabel regExInfo;
    private JScrollPane scrollPane;
    private JPanel rightPanel;
    private  JPanel bottomPanel;
    private  JLabel label;
    public RegexFrame(){

      frame = new JFrame("GUI Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      buildPanel();


        frame.add(scrollPane, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.setSize(1138,700);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

        frame.setVisible(true);
    }

    private void buildPanel() {
        regExInfo=new JLabel(regexInfo);
        regExInfo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        regExInfo.setBackground(Color.WHITE);

        regExInfo.setOpaque(true);



        scrollPane = new JScrollPane(regExInfo);
        scrollPane.createHorizontalScrollBar();


        // Right panel
        rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(400,700));

        // Bottom panel
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);

        label = new JLabel("Welcome @mahmutunder");
        label.setForeground(Color.WHITE);
        bottomPanel.add(label);

        JLabel pane= new JLabel("hello");
        pane.setHorizontalAlignment(JLabel.CENTER);


        rightPanel.add(tester, BorderLayout.NORTH);
        rightPanel.add(pane,BorderLayout.CENTER);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

}
