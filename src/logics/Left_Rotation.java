package logics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Left_Rotation {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int r=2;
        System.out.println(Arrays.toString(solution(arr,r)));
    }
    static int[] solution(int[] arr,int r){
        for (int i = 0; i < r; i++) {
            int first=arr[0];
            for (int j = 0; j < arr.length-1; j++) {
                arr[j]=arr[j+1];
            }
            arr[arr.length-1]=first;
        }
        return arr;
        }
}
