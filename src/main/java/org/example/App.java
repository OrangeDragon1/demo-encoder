package org.example;

public class App {
    public static void main( String[] args ) {
        OffsetEncoder offsetEncoder = new OffsetEncoder();
        String text = "HELLO WORLD";
        String encodedText = offsetEncoder.encode(text);
        String decodedText = offsetEncoder.decode(encodedText);
    }

}
