package logics.assignment3;

public class subset {
    public static void main(String[] args) {
        String str = "FUN";
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                //System.out.print(str.charAt(j))   02
                System.out.println(str.substring(i,j));

            }

        }
    }
}
