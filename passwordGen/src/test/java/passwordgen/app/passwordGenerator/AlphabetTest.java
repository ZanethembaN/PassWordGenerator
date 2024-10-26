package passwordgen.app.passwordGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AlphabetTest {

    @Test
    public void testAlphabetCreation() {
        Alphabet alphabet = new Alphabet(true, true, true, true);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()-_=+\\/~?";
        assertEquals(expected, alphabet.getAlphabet());
    }

    @Test
    public void testAlphabetWithoutSymbols() {
        Alphabet alphabet = new Alphabet(true, true, true, false);
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        assertEquals(expected, alphabet.getAlphabet());
    }

    @Test
    public void testAlphabetWithOnlyLowercase() {
        Alphabet alphabet = new Alphabet(false, true, false, false);
        String expected = "abcdefghijklmnopqrstuvwxyz";
        assertEquals(expected, alphabet.getAlphabet());
    }
}
