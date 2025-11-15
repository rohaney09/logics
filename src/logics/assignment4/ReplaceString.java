package logics.assignment4;

import java.util.Scanner;

public class ReplaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        str = str.replace(' ', ch);
        System.out.println("string: " + str);
    }
}


