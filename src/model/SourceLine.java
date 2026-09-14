// Represents a line of source code in the SIC/XE assembler.

// Must have an
// - source line number
// - original text
// - optional label
// - operation
// - optional operand
// - optional comment
// - whether the link is blank or comment-only

package model;

public class SourceLine {
    private final int lineNumber;
    private final String originalText;
    private final String label;
    private final String operation;
    private final String operand;
    private final String comment;
    private final boolean blank;
    private final boolean commentOnly;
    
}
