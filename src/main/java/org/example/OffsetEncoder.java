package org.example;

public class OffsetEncoder {

    private static final String REFERENCE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    public static String encode(String plainText) {
        System.out.printf("Input text: %s\n", plainText);

        int randomInt = (int) Math.floor(Math.random() * (43 + 1));
//        System.out.printf("Offset character: %c\n", REFERENCE_TABLE.charAt(randomInt));

        StringBuilder sb = new StringBuilder();
        sb.append(REFERENCE_TABLE.charAt(randomInt));
        for (char c : plainText.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            int index = REFERENCE_TABLE.indexOf(c);
            int newIndex = index - randomInt;
            if (newIndex < 0) {
                newIndex = newIndex + REFERENCE_TABLE.length();
            }

            char newChar = REFERENCE_TABLE.charAt(newIndex);
            sb.append(newChar);
        }

        String encodedText = sb.toString();
        System.out.printf("Encoded text: %s\n", encodedText);
        return encodedText;
    }

    public static String decode(String encodedText) {
        System.out.printf("Encoded text: %s\n", encodedText);

        char offsetChar = encodedText.charAt(0);
        int offset = REFERENCE_TABLE.indexOf(offsetChar);
//        System.out.printf("Offset character: %c\n", offsetChar);

        String text = encodedText.substring(1);
//        System.out.printf("Text: %s\n", text);

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            int index = REFERENCE_TABLE.indexOf(c);
            int newIndex = index + offset;

            if (newIndex > REFERENCE_TABLE.length() - 1) {
                newIndex = newIndex - REFERENCE_TABLE.length();
            }
            sb.append(REFERENCE_TABLE.charAt(newIndex));
        }

        String decodedText = sb.toString();
        System.out.printf("Decoded text: %s\n", decodedText);
        return decodedText;
    }
}
