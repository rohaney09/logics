package logics.assignment4;

import java.util.Scanner;

public class ReplaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();
        System.out.print("Enter character: ");
        //char ch = 'A';
        char ch = sc.next().charAt(0);
        str = str.replace(' ', ch);
        System.out.println("string: " + str);
    }
}


