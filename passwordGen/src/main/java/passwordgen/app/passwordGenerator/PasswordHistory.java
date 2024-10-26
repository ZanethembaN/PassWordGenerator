package passwordgen.app.passwordGenerator;

import java.util.ArrayList;
import java.util.List;

public class PasswordHistory {
    private final List<String> history;

    public PasswordHistory() {
        this.history = new ArrayList<>();
    }

    public void addPassword(String password) {
        history.add(password);
    }

    public List<String> getHistory() {
        return history;
    }
}
