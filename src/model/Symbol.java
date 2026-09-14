package model;

public class Symbol {
    private final String name;
    private final int value;
    private final boolean relocatable;
    private final int definedLine;

    public Symbol(
        String name,
        int value,
        boolean relocatable,
        int definedLine) {
            this.name = name;
            this.value = value;
            this.relocatable = relocatable;
            this.definedLine = definedLine;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return  value;
        }

        public boolean isRelocatable() {
            return relocatable;
        }

        public int getDefinedLine() {
            return definedLine;
        }
}
