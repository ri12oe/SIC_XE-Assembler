package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntermediateLine {
    private final SourceLine sourceLine;
    private final Integer address;
    private String objectCode;
    private final List<String> diagnostics = new ArrayList<>();

    public IntermediateLine(SourceLine sourceLine, Integer address) {
        this.sourceLine = sourceLine;
        this.address = address;
        this.objectCode = "";
    }

    public SourceLine getSourceLine() {
        return sourceLine;
    }

    public Integer getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode == null ? "" : objectCode;
    }

    public void addDiagnostic(String diagnostic) {
        diagnostics.add(diagnostic);
    }

    public List<String> getDiagnostics() {
        return Collections.unmodifiableList(diagnostics);
    }

    public boolean hasDiagnostics() {
        return !diagnostics.isEmpty();
    }

}