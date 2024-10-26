package passwordgen.app.passwordGenerator;

public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public int calculateStrengthScore() {
        boolean[] charTypes = new boolean[4]; // [Uppercase, Lowercase, Numbers, Symbols]

        // Check character types
        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) charTypes[0] = true; // Uppercase
            else if (Character.isLowerCase(c)) charTypes[1] = true; // Lowercase
            else if (Character.isDigit(c)) charTypes[2] = true; // Digit
            else charTypes[3] = true; // Non-alphanumeric as symbols
        }

        // Calculate score based on character types and length
        int score = 0;
        for (boolean type : charTypes) {
            if (type) score++; // Count each character type present
        }

        if (value.length() >= 8) score++; // Add 1 point for length >= 8
        if (value.length() >= 16) score++; // Add another point for length >= 16

        return score;
    }

    @Override
    public String toString() {
        return value;
    }
}
