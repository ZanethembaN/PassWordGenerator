package passwordgen.app.passwordGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    @Test
    public void testCalculateStrengthScore() {
        Password password = new Password("Abc@1234");
        assertEquals(5, password.calculateStrengthScore(), "Expected strength score for 'Abc@1234' to be 4.");
    }

    @Test
    public void testWeakPassword() {
        Password password = new Password("abc");
        assertEquals(1, password.calculateStrengthScore(), "Expected strength score for 'abc' to be 0.");
    }

    @Test
    public void testStrongPassword() {
        Password password = new Password("Strong1$Password");
        assertEquals(6, password.calculateStrengthScore(), "Expected strength score for 'Strong1$Password' to be 5.");
    }

    @Test
    public void testMinimumLengthRequirement() {
        Password password = new Password("A1$");
        assertEquals(3, password.calculateStrengthScore(), "Expected strength score for 'A1$' to be 0 due to insufficient length.");
    }

    @Test
    public void testAllCharacterTypes() {
        Password password = new Password("A1$abcd");
        assertEquals(4, password.calculateStrengthScore(), "Expected strength score for 'A1$abcd' to be 4.");
    }
}
