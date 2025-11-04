package logics.simplePrograms;

import java.util.Scanner;

public class frequency {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String str =  sc.nextLine();
            //String str = "aabbccddee12345671111!%@@!#$%%^&&";
            int [] arr = new int[127];

            for(int i=0; i< str.length() ; i++)
            {
                char ch  = str.charAt(i);
                arr[ch]++;
            }
            System.out.println("frequency---------");
            for (int i = 0; i <arr.length ; i++) {
                if(arr[i] >=1)
                {
                    System.out.println((char)i + " "+ arr[i]);
                }
            }
            System.out.println("unique---------");
            for (int i = 0; i <arr.length ; i++) {
                if(arr[i] ==1)
                {
                    System.out.println((char)i + " "+ arr[i]);
                }
            }
            System.out.println("Duplicate---------");
            for (int i = 0; i <arr.length ; i++) {
                if(arr[i] >=2)
                {
                    System.out.println((char)i + " "+ arr[i]);
                }
            }

    }
}

