package passwordgen.app.passwordGenerator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PasswordHistoryTest {

    @Test
    public void testAddAndRetrievePassword() {
        PasswordHistory history = new PasswordHistory();
        history.addPassword("TestPassword1");
        List<String> passwords = history.getHistory();

        assertEquals(1, passwords.size());
        assertEquals("TestPassword1", passwords.get(0));
    }

    @Test
    public void testMultiplePasswords() {
        PasswordHistory history = new PasswordHistory();
        history.addPassword("Password1");
        history.addPassword("Password2");

        List<String> passwords = history.getHistory();

        assertEquals(2, passwords.size());
        assertEquals("Password1", passwords.get(0));
        assertEquals("Password2", passwords.get(1));
    }
}
