package passwordgen.app.passwordGenerator;

import java.util.Scanner;
import java.util.Random;

public class Generator {
    private Alphabet alphabet;
    private static Scanner keyboard;
    PasswordHistory passwordHistory;

    public Generator(Scanner scanner) {
        keyboard = scanner;
        passwordHistory = new PasswordHistory();
    }

    public void mainLoop() {
        System.out.println("Welcome to Password Services :)");
        printMenu();
        String userOption = "-1";

        while (!userOption.equals("5")) {
            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> {
                    showPasswordHistory();
                    printMenu();
                }
                case "5" -> printQuitMessage();
                default -> {
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }

    void requestPassword() {
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNum = false;
        boolean includeSym = false;
        boolean correctParams;

        System.out.println("Hello, welcome to the Password Generator :) answer the following questions by Yes or No \n");

        do {
            String input;
            correctParams = false;

            // Input for lowercase
            do {
                System.out.println("Do you want Lowercase letters to be used? ");
                input = keyboard.next();
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            includeLower = input.equalsIgnoreCase("yes");

            // Input for uppercase
            do {
                System.out.println("Do you want Uppercase letters to be used? ");
                input = keyboard.next();
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            includeUpper = input.equalsIgnoreCase("yes");

            // Input for numbers
            do {
                System.out.println("Do you want Numbers to be used? ");
                input = keyboard.next();
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            includeNum = input.equalsIgnoreCase("yes");

            // Input for symbols
            do {
                System.out.println("Do you want Symbols to be used? ");
                input = keyboard.next();
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            includeSym = input.equalsIgnoreCase("yes");

            // Check if at least one option is selected
            if (!includeUpper && !includeLower && !includeNum && !includeSym) {
                System.out.println("At least one character type must be selected.");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        alphabet = new Alphabet(includeUpper, includeLower, includeNum, includeSym);
        String generatedPassword = generatePassword(length);
        passwordHistory.addPassword(generatedPassword);

        System.out.println("Your generated password: " + generatedPassword);
    }

    private String generatePassword(int length) {
        StringBuilder pass = new StringBuilder();
        String alphabetString = alphabet.getAlphabet();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * alphabetString.length());
            pass.append(alphabetString.charAt(index));
        }

        return pass.toString();
    }

    private void showPasswordHistory() {
        System.out.println("Password History:");
        for (String password : passwordHistory.getHistory()) {
            System.out.println(password);
        }
    }

    private void printUsefulInfo() {
        System.out.println("Use a minimum password length of 8 or more characters if permitted.");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers, and symbols if permitted.");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts).");
    }

    private void checkPassword() {
        System.out.print("Enter your password: ");
        String input = keyboard.next();
        Password password = new Password(input);
        System.out.println(password.calculateStrengthScore());
    }

    private void printMenu() {
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Show Password History");
        System.out.println("Enter 5 - Quit");
        System.out.print("Choice: ");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program, goodbye!");
    }

    public String createRandomPassword(int length, Alphabet alphabet) {
        StringBuilder password = new StringBuilder();
        String charPool = alphabet.getAlphabet();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            password.append(charPool.charAt(index));
        }

        return password.toString();
    }
}


