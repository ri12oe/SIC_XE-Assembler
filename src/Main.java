import model.Instruction;
import tables.OpcodeTable;

public class Main {
    public static void main(String[] args) {
        OpcodeTable opcodeTable = new OpcodeTable();

        Instruction lda = opcodeTable.find("lda").orElseThrow();

        System.out.printf(
            "%s opcode=%02X formats=%s%n",
            lda.getMnemonic(),
            lda.getOpcode(),
            lda.getFormats()
        );

        System.out.println("CLEAR supports format 2: " +
            opcodeTable.find("CLEAR").orElseThrow().supportsFormat(2));

        System.out.println("RSUB supports format 4: " +
            opcodeTable.find("RSUB").orElseThrow().supportsFormat(4));

        System.out.println("INVALID exists: " +
            opcodeTable.contains("INVALID"));
    }
}