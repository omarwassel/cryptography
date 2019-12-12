package com.cryptography.classes;

public class PlayFairCipher extends Cipher {

    private String key = "";
    private char[][] matrix = new char[5][5];
    private boolean[] alphapetChecker = new boolean[26];
    private int[][] charPosition = new int[2][26];

    
    public PlayFairCipher(String key) {
        this.key = key;
        buildMatrix(key);
    }
    
    public PlayFairCipher() {
        this("security");
    }
    
    private void buildMatrix(String key) {
        String alphapetChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder str = new StringBuilder(key + alphapetChars);
        alphapetChecker['j' - 'a'] = true;
        
        int strIdx = 0;
        for (int i = 0; i < 25; i++) {
            if (str.charAt(strIdx) == 'j') //any j conveted to i
            {
                str=str.replace(strIdx, strIdx + 1, "i");
            }

            while (strIdx < str.length() && alphapetChecker[str.charAt(strIdx) - 'a'] == true) //don't take repeted char                 
            {
                strIdx++;
            }

            alphapetChecker[str.charAt(strIdx) - 'a'] = true;//set char is visited
            matrix[i / 5][i % 5] = str.charAt(strIdx); //insert in matrix
            charPosition[0][str.charAt(strIdx) - 'a'] = i / 5;  //record row of char 
            charPosition[1][str.charAt(strIdx) - 'a'] = i % 5;  //record col of char
            strIdx++;
        }

    }
    
    @Override
    public String encrypt(String message) {
        String formatedMessage = formatMassage(message), encryptedMessage = "";
        for (int i = 1; i < formatedMessage.length(); i += 2) {
            encryptedMessage += operateTwoChar(formatedMessage.charAt(i - 1), formatedMessage.charAt(i), 1);
        }
        return encryptedMessage;
    }

    @Override
    public String decrypt(String encryptedMessage) {
        String message = "";
        for (int i = 1; i < encryptedMessage.length(); i += 2) {
            message += operateTwoChar(encryptedMessage.charAt(i - 1), encryptedMessage.charAt(i), 4);
        }
        message = cleanMessage(message);
        return message;
    }

    private String operateTwoChar(char ch1, char ch2, int sh) {
        int r1 = charPosition[0][ch1 - 'a'], r2 = charPosition[0][ch2 - 'a'], c1 = charPosition[1][ch1 - 'a'], c2 = charPosition[1][ch2 - 'a'];
        StringBuilder TwoChars = new StringBuilder();
        if (r1 == r2) {
            TwoChars.append((char) matrix[r1][(c1 + sh) % 5]);
            TwoChars.append((char) matrix[r1][(c2 + sh) % 5]);

        } else if (c1 == c2) {
            TwoChars.append((char) matrix[(r1 + sh) % 5][c1]);
            TwoChars.append((char) matrix[(r2 + sh) % 5][c1]);
        } else {
            TwoChars.append((char) matrix[r1][c2]);
            TwoChars.append((char) matrix[r2][c1]);
        }
        return TwoChars.toString();
    }

    private String formatMassage(String massage) {
        if (massage.isEmpty()) {
            return "";
        }

        StringBuilder formatedMassage = new StringBuilder(massage);
        for (int i = 1; i < formatedMassage.length(); i+=2) {
            if (formatedMassage.charAt(i) == formatedMassage.charAt(i - 1)) {
                if (formatedMassage.charAt(i) == 'x') {
                    formatedMassage.insert(i,'y');
                } else {
                    formatedMassage.insert(i,'x');
                }
            }
            

//            if (i + 1 == massage.length() - 1) {
//                formatedMassage.append(massage.charAt(i + 1));
//            }
        }

        if (formatedMassage.length() % 2 == 1) {
            if (formatedMassage.charAt(formatedMassage.length() - 1) == 'x') {
                formatedMassage.append('y');
            } else {
                formatedMassage.append('x');
            }
        }

        return formatedMassage.toString();
    }

    private String cleanMessage(String message) {
        StringBuilder cleanMessage = new StringBuilder(message);
        for (int i = 0; i < cleanMessage.length(); i++) {
            if (cleanMessage.charAt(i) == 'x' && i > 0) {
                if (i == (cleanMessage.length() - 1)) {
                    cleanMessage.deleteCharAt(i);
                    i--;
                } else if (cleanMessage.length() > 2 && i+1<cleanMessage.length()&&cleanMessage.charAt(i - 1) == cleanMessage.charAt(i + 1)) {
                    cleanMessage.deleteCharAt(i);
                    i--;
                }
                

            } else if (cleanMessage.charAt(i) == 'y') {
                 if (cleanMessage.length()>1 && i == (cleanMessage.length() - 1) && cleanMessage.charAt(i - 1)=='x' ) {
                    cleanMessage.deleteCharAt(i);
                    i--;
                } else if (cleanMessage.length() > 2 && i+1<cleanMessage.length() &&cleanMessage.charAt(i - 1) == cleanMessage.charAt(i + 1) && cleanMessage.charAt(i - 1)=='x') {
                    cleanMessage.deleteCharAt(i);
                    i--;
                }
               

            }
        }

        return cleanMessage.toString();
    }

    void display() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
