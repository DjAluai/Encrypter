import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(args[0].equals("0")) {
            Encrypter encrypter = new Encrypter(sc);
            encrypter.ClipMsgFromIn();
        }
        else if(args[0].equals("1")) {
                Decrypter decrypter = new Decrypter(sc);
                decrypter.DecryptFromIn();
        }
    }
}
