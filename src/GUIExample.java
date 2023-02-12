import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class GUIExample {

    private static RegExTester tester;

    private static File regexFile=new File("regex.txt");
    private static Scanner scanner;
    private static String regexInfo;

    static {
        tester= new RegExTester();
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

    public GUIExample(){

        JFrame frame = new JFrame("GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel regExInfo=new JLabel(regexInfo);

        regExInfo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        regExInfo.setBackground(Color.WHITE);
        regExInfo.setOpaque(true);





        JScrollPane scrollPane = new JScrollPane(regExInfo);
        scrollPane.createHorizontalScrollBar();

        // Right panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(400,700));



        // Bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);

        JLabel label = new JLabel("Welcome @mahmutunder");
        label.setForeground(Color.WHITE);
        bottomPanel.add(label);

        rightPanel.add(tester, BorderLayout.NORTH);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(scrollPane, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.setSize(1138,700);
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);
    }

}
