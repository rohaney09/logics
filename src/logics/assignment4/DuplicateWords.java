package logics.assignment4;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class DuplicateWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    System.out.println(words[i]);
                    break;
                }
            }
        }
    }
}



