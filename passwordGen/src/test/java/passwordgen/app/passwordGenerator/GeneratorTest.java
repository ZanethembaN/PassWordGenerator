package passwordgen.app.passwordGenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


class GeneratorTest {

    private Generator generator;

    @BeforeEach
    void setUp() {
        String simulatedInput = "yes\nyes\nyes\nyes\n10\n"; // All options yes, password length 10
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(in);
        generator = new Generator(scanner);
    }

    @Test
    void testGeneratePasswordLength() {
        generator.requestPassword(); // This will generate the password
        String password = generator.createRandomPassword(10, new Alphabet(true, true, true, true));
        assertEquals(10, password.length(), "Password length should match the specified length.");
    }

    @Test
    void testGeneratePasswordContainsAllowedCharacters() {
        generator = new Generator(new Scanner(new ByteArrayInputStream("yes\nno\nyes\nno\n10\n".getBytes()))); // Only lowercase and numbers
        generator.requestPassword(); // This will generate the password
        String password = generator.createRandomPassword(10, new Alphabet(false, true, true, false));

        for (char c : password.toCharArray()) {
            assertTrue(Character.isLowerCase(c) || Character.isDigit(c), "Password should contain only lowercase and digits.");
        }
    }
}
