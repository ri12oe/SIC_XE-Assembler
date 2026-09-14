
// Tests for each files

// import model.Instruction;
// import tables.OpcodeTable;

// public class Main {
//     public static void main(String[] args) {
//         OpcodeTable opcodeTable = new OpcodeTable();

//         Instruction lda = opcodeTable.find("lda").orElseThrow();

//         System.out.printf(
//             "%s opcode=%02X formats=%s%n",
//             lda.getMnemonic(),
//             lda.getOpcode(),
//             lda.getFormats()
//         );

//         System.out.println("CLEAR supports format 2: " +
//             opcodeTable.find("CLEAR").orElseThrow().supportsFormat(2));

//         System.out.println("RSUB supports format 4: " +
//             opcodeTable.find("RSUB").orElseThrow().supportsFormat(4));

//         System.out.println("INVALID exists: " +
//             opcodeTable.contains("INVALID"));
//     }
// }

// import tables.RegisterTable;

// public class Main {
//     public static void main(String[] args) {
//         RegisterTable registerTable = new RegisterTable();

//         System.out.println("A = " +
//             registerTable.find("A").orElseThrow());

//         System.out.println("x = " +
//             registerTable.find("x").orElseThrow());

//         System.out.println("Q is valid: " +
//             registerTable.contains("Q"));
//     }
// }



import model.IntermediateLine;
import model.Literal;
import model.SourceLine;
import model.Symbol;

public class Main {
    public static void main(String[] args) {
        SourceLine sourceLine = new SourceLine(
                1,
                "FIRST   LDA     VALUE",
                "FIRST",
                "LDA",
                "VALUE",
                null,
                false,
                false);

        IntermediateLine intermediateLine =
                new IntermediateLine(sourceLine, 0x1000);

        Symbol symbol = new Symbol("FIRST", 0x1000, true, 1);

        Literal literal = new Literal(
                "=C'EOF'",
                new byte[] { 'E', 'O', 'F' });

        System.out.printf(
                "%s at %04X%n",
                symbol.getName(),
                intermediateLine.getAddress());

        System.out.printf(
                "%s length=%d%n",
                literal.getSpelling(),
                literal.getLength());
    }
}