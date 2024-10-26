package passwordgen.app.passwordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class PasswordGeneratorGUI extends JFrame {
    private final JTextField lengthField;
    private final JTextField countField;
    private final JTextArea outputArea;
    private final JCheckBox upperCaseCheck;
    private final JCheckBox lowerCaseCheck;
    private final JCheckBox numberCheck;
    private final JCheckBox symbolCheck;
    private final Generator generator;

    public PasswordGeneratorGUI() {
        generator = new Generator(new Scanner(System.in)); // Pass the scanner if needed
        setTitle("Password Generator");
        setSize(600, 500); // Enlarged window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10)); // Added padding
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding around the panel

        inputPanel.add(new JLabel("Password Length (8-20):"));
        lengthField = new JTextField();
        inputPanel.add(lengthField);

        inputPanel.add(new JLabel("Number of Passwords:"));
        countField = new JTextField();
        inputPanel.add(countField);

        upperCaseCheck = new JCheckBox("Include Uppercase Letters");
        lowerCaseCheck = new JCheckBox("Include Lowercase Letters");
        numberCheck = new JCheckBox("Include Numbers");
        symbolCheck = new JCheckBox("Include Symbols");

        inputPanel.add(upperCaseCheck);
        inputPanel.add(lowerCaseCheck);
        inputPanel.add(numberCheck);
        inputPanel.add(symbolCheck);

        JButton generateButton = new JButton("Generate Passwords");
        generateButton.setPreferredSize(new Dimension(200, 40)); // Enlarged button size
        generateButton.addActionListener(new GenerateButtonListener());
        inputPanel.add(generateButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Monospaced font for better readability
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(580, 300)); // Enlarged output area size

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int length = Integer.parseInt(lengthField.getText());
                int count = Integer.parseInt(countField.getText());

                if (length < 8 || length > 20) {
                    outputArea.setText("Length must be between 8 and 20.");
                    return;
                }
                if (count <= 0) {
                    outputArea.setText("Number of passwords must be positive.");
                    return;
                }

                Alphabet alphabet = new Alphabet(
                        upperCaseCheck.isSelected(),
                        lowerCaseCheck.isSelected(),
                        numberCheck.isSelected(),
                        symbolCheck.isSelected()
                );

                StringBuilder passwords = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    passwords.append(generator.createRandomPassword(length, alphabet)).append("\n");
                }

                outputArea.setText(passwords.toString());

            } catch (NumberFormatException ex) {
                outputArea.setText("Please enter valid numbers for length and count.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordGeneratorGUI gui = new PasswordGeneratorGUI();
            gui.setVisible(true);
        });
    }
}
