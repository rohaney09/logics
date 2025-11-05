package logics.assignment3;

import java.util.Scanner;

public class vowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String v = str.replaceAll("[aeiouAEIOU]", "");
        System.out.println(v.length()-1);

    }

}
