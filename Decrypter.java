import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.*;

public class Decrypter {
    private Scanner sc;
    private char ch0;  //zero
    private char ch1;  //one
    private String message;

    public Decrypter(Scanner in) {
        sc = in;
        message = "";
        ch0 = '0';
        ch1 = '1';
    }

    public void readMessage() {
        message = sc.nextLine();
        ch1 = message.charAt(0);
        message = message.substring(1,message.length());
    }

    public void putInClipboard() {
        StringSelection stringSelection = new StringSelection(message);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void turnChar() {
        char ch;
        String ans = "";
        String str = message;
        for(int i=0; i<str.length()/8; i++) {
            ans += turnBinaryCh(str.substring(i*8, (i+1)*8));
        }
        message = ans;
    }

    private void getCh1() {

    }

    private void writeMsg() {System.out.println(message);}

    private char turnBinaryCh(String str) {
        char ch;
        int n = 0;
        if(str.length() != 8) throw new RuntimeException("Wtf");
        for(int i=0; i<8; i++) {
            ch = str.charAt(i);
            if(ch == ch1) {
                n += (int) Math.pow(2,7-i);
            }
        }
        return (char) n;
    }

    public void DecryptFromIn() {
        readMessage();
        turnChar();
        putInClipboard();
        writeMsg();
    }
}
