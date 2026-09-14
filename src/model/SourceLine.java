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

    public SourceLine(
        int lineNumber,
        String originalText,
        String label,
        String operation,
        String operand,
        String comment,
        boolean blank,
        boolean commentOnly) {
            this.lineNumber = lineNumber;
            this.originalText = originalText;
            this.label = label;
            this.operation = operation;
            this.comment = comment;
            this.blank = blank;
            this.commentOnly = commentOnly;
        }
        
        public int getLineNumber() {
            return lineNumber;
        }

        public String getOriginalText() {
            return originalText;
        }

        public String getLabel() {
            return label;
        }

        public String getOperation() {
            return operation;
        }

        public String getOperand() {
            return operand;
        }

        public String getComment() {
            return comment;
        }

        public boolean isBlank() {
            return blank;
        }

        public boolean isCommentOnly() {
            return commentOnly;
        }
    
}
