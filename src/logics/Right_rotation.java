package logics;

import java.util.Arrays;

public class Right_rotation {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int r=2;
        System.out.println(Arrays.toString(solution(arr,r)));
    }
    static int[] solution(int[]arr,int r){
        for (int i = 0; i < r; i++) {
            int last= arr[arr.length-1];
            for (int j = arr.length-1; j >0 ; j--) {
                arr[j]=arr[j-1];
            }
            arr[0]= last;
        }
        return arr;
        }
}
