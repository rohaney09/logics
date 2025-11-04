package logics.simplePrograms;

import java.util.Scanner;

public class leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value");
        int value = sc.nextInt();
        if((value %4==0) && (value % 100!= 0)||(value %400 ==0)) {
            System.out.println("leap");
        }
        else{
                System.out.println("not leap");
            }
    }
}
