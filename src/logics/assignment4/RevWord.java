package logics.assignment4;

import java.util.Scanner;

public class RevWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] rev = str.split(" ");
        String revStr = "";

        for (int i = rev.length - 1; i >= 0; i--) {
            revStr  = revStr + rev[i]+" ";
        }
        System.out.println(revStr);
    }
}
