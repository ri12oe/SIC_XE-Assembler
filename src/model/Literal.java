package model;

import java.util.Arrays;

public class Literal {
    private final String spelling;
    private final byte[] bytes;
    private Integer address;
    private boolean emitted;

    public Literal(String spelling, byte[] bytes) {
        this.spelling = spelling;
        this.bytes = Arrays.copyOf(bytes, bytes.length);
        this.address = null;
        this.emitted = false;
    }

    public String getSpelling() {
        return spelling;
    }

    public byte[] getBytes() {
        return Arrays.copyOf(bytes, bytes.length);
    }

    public int getLength() {
        return bytes.length;
    }

    public Integer getAddress() {
        return address;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void assignAddress(int address) {
        this.address = address;
    }

    public boolean isEmitted() {
        return emitted;
    }

    public void markEmitted() {
        emitted = true;
    }

}