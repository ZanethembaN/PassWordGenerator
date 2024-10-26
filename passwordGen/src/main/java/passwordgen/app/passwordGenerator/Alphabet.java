package passwordgen.app.passwordGenerator;

public class Alphabet {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    private final StringBuilder pool;

    public Alphabet(boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym) {
        pool = new StringBuilder();
        if (includeUpper) pool.append(UPPERCASE_LETTERS);
        if (includeLower) pool.append(LOWERCASE_LETTERS);
        if (includeNum) pool.append(NUMBERS);
        if (includeSym) pool.append(SYMBOLS);
    }

    public String getAlphabet() {
        return pool.toString();
    }
}
