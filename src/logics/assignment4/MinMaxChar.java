package logics.assignment4;

import org.ietf.jgss.GSSManager;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxChar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[127];
        char ch;
        int large = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            arr[ch]++;
        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= 1) {
//
//                System.out.println((char) i + " " + arr[i]);
//            }
//        }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                    if (arr[i] > large) {
                        large = arr[i];
                    }
                    if (arr[i] < smallest) {
                        smallest = arr[i];
                    }
            }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==large){
                System.out.println("larger char: ");
                System.out.println((char)i+" "+large);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==smallest){
                System.out.println("smallest char: ");
                System.out.println((char)i+" "+smallest);
            }
        }



//        System.out.println("large: "+large);
//        System.out.println("small: "+smallest);
    }
}


