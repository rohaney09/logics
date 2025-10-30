package logics;

import java.util.Scanner;

public class substring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        String R = "";
        int start = in.nextInt();
        int end = in.nextInt();
        for(int j=start;j<=end;j++) {
            R =  R+S.charAt(j);
            }
        System.out.println(R);
    }
}
