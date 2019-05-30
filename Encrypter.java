import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.*;

public class Encrypter {
    private Scanner sc;
    private char ch0;  //zero
    private char ch1;  //one
    private String message;

    public Encrypter(Scanner in) {
        sc = in;
        message = "";
        ch0 = '0';
        ch1 = '1';
    }

    public void readMessage() {
        message = sc.nextLine();
    }

    public void putInClipboard() {
        StringSelection stringSelection = new StringSelection(message);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void turnBinary() {
        char ch;
        String ans = "";
        String str = message;
        for(int i=0; i<str.length(); i++) {
            ch = str.charAt(i);
            ans += turnChBinary(ch);
        }
        message = ans;
    }

    private void updatechars() {
        FileInputStream fin = null;
        try {
            File file = new File("Chars.txt");
            fin = new FileInputStream(file);

            ch0 = (char) fin.read();
            ch1 = (char) fin.read();

            //Work in progress

            fin.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private String turnChBinary(char ch) {
        String ans = "";
        int n = (int) ch;

        for(int i=7; i>=0; i--) {
            if(((int)Math.pow(2,i)) <= n) {
                n -= (int)Math.pow(2,i);
                ans += ch1;
            }
            else ans += ch0;
        }
        return ans;
    }

    public void ClipMsgFromIn(){
        updatechars();
        readMessage();
        turnBinary();
        message = ch1 + message;
        putInClipboard();
    }
}
