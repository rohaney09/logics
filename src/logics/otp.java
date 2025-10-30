package logics;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class otp {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 1000 + r.nextInt(8999);
        System.out.println(n);
    }
}
