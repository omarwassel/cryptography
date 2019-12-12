package com.cryptography.forms;

import javax.print.DocFlavor;
import com.cryptography.classes.*;
import java.util.stream.Stream;

public class HomeFrame extends javax.swing.JFrame {

    private String cipherType;
    private String Key;
    private CaesarCipher caeserCipher;
    private PlayFairCipher PlayFairCipher;
    private xorCipher xorCipher;

    public HomeFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CipherCheckBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        massageTxtField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        encryptedMassageTxtField = new javax.swing.JTextArea();
        EncryptionBtn = new javax.swing.JButton();
        DecryptionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        encryptedTxtErasingBtn = new javax.swing.JButton();
        massageTxtErasingBtn = new javax.swing.JButton();
        keyTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CipherCheckBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ceaser Cipher ", "Play Fair Cipher", "XOR Cipher" }));
        CipherCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CipherCheckBoxActionPerformed(evt);
            }
        });
        getContentPane().add(CipherCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 280, -1));

        massageTxtField.setColumns(20);
        massageTxtField.setRows(5);
        jScrollPane1.setViewportView(massageTxtField);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 352, 230));

        encryptedMassageTxtField.setColumns(20);
        encryptedMassageTxtField.setRows(5);
        jScrollPane2.setViewportView(encryptedMassageTxtField);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 126, 360, 230));

        EncryptionBtn.setText("Encrypt");
        EncryptionBtn.setName("btn"); // NOI18N
        EncryptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EncryptionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 132, -1));

        DecryptionBtn.setText("Decrypt");
        DecryptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptionBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DecryptionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 130, -1));

        jLabel1.setText("Choose Cipher  ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 93, 19));

        encryptedTxtErasingBtn.setText("Erase");
        encryptedTxtErasingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptedTxtErasingBtnActionPerformed(evt);
            }
        });
        getContentPane().add(encryptedTxtErasingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 362, -1, -1));

        massageTxtErasingBtn.setText("Erase");
        massageTxtErasingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massageTxtErasingBtnActionPerformed(evt);
            }
        });
        getContentPane().add(massageTxtErasingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 362, -1, -1));
        getContentPane().add(keyTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 280, -1));

        jLabel2.setText("Key:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));
        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 130, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EncryptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptionBtnActionPerformed

        getComponantReads();
        String massage = massageTxtField.getText();
        
        if (cipherType.equals("Ceaser Cipher ")) {
            if (Key.matches("\\d+")) {
                caeserCipher = new CaesarCipher(Integer.parseInt(Key));
            } else {
                caeserCipher = new CaesarCipher();
            }

            encryptedMassageTxtField.setText(caeserCipher.encrypt(massage));
        }
        if (cipherType.equals("Play Fair Cipher")) {
            if (Key.matches("[a-zA-Z]+")) {
                PlayFairCipher = new PlayFairCipher(Key);
            } else {
                PlayFairCipher = new PlayFairCipher();
            }
            encryptedMassageTxtField.setText(PlayFairCipher.encrypt(massage));
        }
        if (cipherType.equals("XOR Cipher")) {
            if (Key.matches("\\d+")) {
                xorCipher = new xorCipher(Integer.parseInt(Key));
            } else {
                xorCipher = new xorCipher();
            }
            encryptedMassageTxtField.setText(xorCipher.encrypt(massage));
        }


    }//GEN-LAST:event_EncryptionBtnActionPerformed

    private void CipherCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CipherCheckBoxActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_CipherCheckBoxActionPerformed

    private void DecryptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptionBtnActionPerformed
        // TODO add your handling code here:
        getComponantReads();
        String massage = encryptedMassageTxtField.getText();
        if (cipherType.equals("Ceaser Cipher ")) {
            if (Key.matches("\\d+")) {
                caeserCipher = new CaesarCipher(Integer.parseInt(Key));
            } else {
                caeserCipher = new CaesarCipher();
            }

            massageTxtField.setText(caeserCipher.decrypt(massage));
        }
        if (cipherType.equals("Play Fair Cipher")) {
            if (Key.matches("[a-z]+")) {
                PlayFairCipher = new PlayFairCipher(Key);
            } else {
                PlayFairCipher = new PlayFairCipher();
            }

            massageTxtField.setText(PlayFairCipher.decrypt(massage));
        }
        if (cipherType.equals("XOR Cipher")) {
            if (Key.matches("\\d+")) {
                xorCipher = new xorCipher(Integer.parseInt(Key));
            } else {
                xorCipher = new xorCipher();
            }
            massageTxtField.setText(xorCipher.decrypt(massage));
        }


    }//GEN-LAST:event_DecryptionBtnActionPerformed

    private void getComponantReads() {
        cipherType = CipherCheckBox.getSelectedItem().toString();
        Key = keyTxtField.getText();
    }


    private void massageTxtErasingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_massageTxtErasingBtnActionPerformed
        // TODO add your handling code here:
        massageTxtField.setText("");
    }//GEN-LAST:event_massageTxtErasingBtnActionPerformed

    private void encryptedTxtErasingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptedTxtErasingBtnActionPerformed
        // TODO add your handling code here:
        encryptedMassageTxtField.setText("");
    }//GEN-LAST:event_encryptedTxtErasingBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeFrame myFrame = new HomeFrame();
                myFrame.setVisible(true);
                myFrame.setTitle("CryptoGraphy Project");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CipherCheckBox;
    private javax.swing.JButton DecryptionBtn;
    private javax.swing.JButton EncryptionBtn;
    private javax.swing.JTextArea encryptedMassageTxtField;
    private javax.swing.JButton encryptedTxtErasingBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField keyTxtField;
    private javax.swing.JButton massageTxtErasingBtn;
    private javax.swing.JTextArea massageTxtField;
    // End of variables declaration//GEN-END:variables
}
