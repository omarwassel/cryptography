package com.cryptography.classes;

public class CaesarCipher extends Cipher {

    private int key;
    

    public CaesarCipher() {
        this.key = 0;
    }

    public CaesarCipher(int key) {
        this.key = key;
    }

    @Override
    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : message.toCharArray()) {
            if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar + key - 'a') % 26 + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encryptedMessage) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : encryptedMessage.toCharArray()) {
           if (Character.isLowerCase(currentChar)) {
                char ch = (char) (((int) currentChar - key - 'a' + 26) % 26 + 'a');
                result.append(ch);
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

}
