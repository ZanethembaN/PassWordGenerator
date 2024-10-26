package passwordgen.app.passwordGenerator;

import javax.swing.JOptionPane;

public class HelpDialog {
    public static void showHelp() {
        JOptionPane.showMessageDialog(null, "This is a simple Password Generator.\n\n"
                + "1. Generate a Password: Choose character types and length.\n"
                + "2. Check Password Strength: Enter a password to evaluate its strength.\n"
                + "3. Useful Information: Read tips on password security.\n"
                + "4. Show Password History: View previously generated passwords.\n"
                + "5. Quit: Exit the application.");
    }
}
