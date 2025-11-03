package logics;
import java.util.Scanner;

class   Solution {
    public static void main(String[] args) {


       String s = "welcometojava";
       int k =3;

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // Loop through the string to get all substrings of length k
        for (int i = 1; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);

            // Compare lexicographically
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }

            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }
        System.out.println("smallest: " + smallest);
        System.out.println("largest: " + largest);
       // return smallest + "\n" + largest;
    }

}
