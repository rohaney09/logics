package logics;
import java.util.*;

public class lexicographical {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        //String[] arr=new String[16];
        int len=s.length();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<len-3;i++){
            String res="";
            for(int j=0;j<3;j++){
                res+=s.charAt(j);
            }
//            arr[i]=res;
            list.add(res);

            s=s.substring(1,s.length());
        }
//    Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        Collections.sort(list);
        System.out.println(list);
    }
}
