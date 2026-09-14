package tables;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import model.Instruction;

public class OpcodeTable {
    // store the data structures
    private final Map<String, Instruction> instructions = new HashMap<>();

    public OpcodeTable() {
        //  add("mnemonic", opcode, vaild formats)
        add("ADD", 0x18, Set.of(3,4));
        add("ADDF", 0x58, Set.of(3,4));
        add("ADDR", 0x90, Set.of(2));

        add("AND", 0x40, Set.of(3,4));

        add("CLEAR", 0xB4, Set.of(2));
        add("COMP", 0x28, Set.of(3,4));
        add("COMPF", 0x88, Set.of(3,4));
        add("COMPR", 0xA0, Set.of(2));

        add("DIV", 0x24, Set.of(3,4));
        add("DIVF", 0x64, Set.of(3,4));
        add("DIVR", 0x9C, Set.of(2));

        add("FIX", 0xC4, Set.of(1));
        add("FLOAT", 0xC0, Set.of(1));

        add("J", 0x3C, Set.of(3,4));
        add("JEQ", 0x30, Set.of(3,4));
        add("JGT", 0x34, Set.of(3,4));
        add("JLT", 0x38, Set.of(3,4));
        add("JSUB", 0x48, Set.of(3,4));

        add("LDA", 0x00, Set.of(3,4));
        add("LDB", 0x68, Set.of(3,4));
        add("LDCH", 0x50, Set.of(3,4));
        add("LDF", 0x70, Set.of(3,4));
        add("LDI", 0x08, Set.of(3,4));
        add("LDS", 0x6C, Set.of(3,4));
        add("LDT", 0x74, Set.of(3,4));
        add("LDX", 0x04, Set.of(3,4));

        add("MUL", 0x20, Set.of(3,4));
        add("MULF", 0x60, Set.of(3,4));
        add("MULR", 0x98, Set.of(2));

        add("NORM", 0xC8, Set.of(1));

        add("OR", 0x44, Set.of(3,4));

        add("RD", 0xD8, Set.of(3,4));
        add("RMO", 0xAC, Set.of(2));
        add("RSUB", 0x4C, Set.of(3));

        add("SHIFTL", 0xA4, Set.of(2));
        add("SHIFTR", 0xA8, Set.of(2));
        add("SIO", 0xF0, Set.of(1));
        add("SSK", 0xEC, Set.of(3,4));
        add("STA", 0x0C, Set.of(3,4));
        add("STB", 0x78, Set.of(3,4));
        add("STCH", 0x54, Set.of(3,4));
        add("STF", 0x80, Set.of(3,4));
        add("STI", 0xD4, Set.of(3,4));
        add("STL", 0x14, Set.of(3,4));
        add("STS", 0x7C, Set.of(3,4));
        add("STSW", 0xE8, Set.of(3,4));
        add("STT", 0x84, Set.of(3,4));
        add("STX", 0x10, Set.of(3,4));
        add("SUB", 0x1C, Set.of(3,4));
        add("SUBF", 0x5C, Set.of(3,4));
        add("SUBR", 0x94, Set.of(2));

        add("SVC", 0xB0, Set.of(2));
        add("TD", 0xE0, Set.of(3,4));
        add("TIO", 0xF8, Set.of(1));
        add("TIX", 0x2C, Set.of(3,4));
        add("TIXR", 0xB8, Set.of(2));
        add("WD", 0xDC, Set.of(3,4));
    }

    private void add(String mnemonic, int opcode, Set<Integer> formats) {
        // build an object to store it in the map
        instructions.put(
            mnemonic,
            new Instruction(mnemonic, opcode, formats)
        );
    }

    public Optional<Instruction> find (String mnemonic) {
        // trims whitspace, converts letters, return optional
        if (mnemonic == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            instructions.get(mnemonic.trim().toUpperCase())
        );
    }
    
    public boolean contains(String mnemonic) {
        // to check if valid
        return find(mnemonic).isPresent();
    }
}
