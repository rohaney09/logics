package logics.simplePrograms;

import java.util.Random;

public class otp {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 1000 + r.nextInt(8999);
        System.out.println(n);
    }
}
