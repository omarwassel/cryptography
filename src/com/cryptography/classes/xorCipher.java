/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cryptography.classes;

/**
 *
 * @author omar
 */
public class xorCipher extends Cipher{

    private  int key;
    
    public xorCipher() {
        this.key=0;
    }
    public xorCipher(int key) {
        this.key=key;
    }
    

    @Override
    public String encrypt(String message) {
        char [] massageArray=message.toCharArray();
        StringBuilder encryptedMassage = new StringBuilder();
        for (char c : massageArray) {
            encryptedMassage.append((char)(c^key));
        }
        return encryptedMassage.toString();
    }

    @Override
    public String decrypt(String encryptedMessage) {
        return encrypt(encryptedMessage);
    }
    
}
