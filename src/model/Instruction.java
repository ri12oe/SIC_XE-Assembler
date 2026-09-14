package model;

// Represents one row of the opcode table
import java.util.Set;

public class Instruction {
    private final String mnemonic;
    private final int opcode;
    private final Set<Integer> formats;
    public Instruction(String mnemonic, int opcode, Set<Integer> formats) {
        this.mnemonic = mnemonic;
        this.opcode = opcode;
        this.formats = Set.copyOf(formats);
    }
    public String getMnemonic() {
        return mnemonic;
    }

    public int getOpcode() {
        return opcode;
    }

    public Set<Integer> getFormats() {
        return formats;
    }

    public boolean supportsFormat(int format) {
        return formats.contains(format);
    }
}