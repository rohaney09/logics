package logics.assignment2;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,6,3,4};
        int len = arr.length-1;
        int flag = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag==0)break;
        }
        for(int i = 0; i < len; i++){
            System.out.println(arr[i]);
        } 

    }
}
