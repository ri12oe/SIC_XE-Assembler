package tables;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegisterTable {
    private final Map<String, Integer> registers = new HashMap<>();
    public RegisterTable() {
        // references: https://docs.sicxe.run/docs/reference/registers/
        registers.put("A", 0);
        registers.put("X", 1);
        registers.put("L", 2);
        registers.put("B", 3);
        registers.put("S", 4);
        registers.put("T", 5);
        registers.put("F", 6);
        registers.put("PC", 8);
        registers.put("SW", 89); 
    }

    public Optional<Integer> find (String registerName) {
        // handles comman inputs. ex if left value blank, then returns 0
        if (registerName == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            registers.get(registerName.trim().toUpperCase())
        );
    }

    public boolean contains(String registerName) {
        return find(registerName).isPresent();
    }
}
