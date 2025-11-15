package logics.assignment4;

public class StringRotation {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "BCDA";
        System.out.println(str1.length() == str2.length() && (str1 + str1).contains(str2) ? "rotation" : "not rotation" );
    }
}


