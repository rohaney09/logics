package logics.assignment4;

public class StringRotation {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "BCDA";

        if (isRotation(str1, str2)) {
            System.out.println(str2 + " is a rotation of " + str1);
        } else {
            System.out.println(str2 + " is NOT a rotation of " + str1);
        }
    }

    static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;

        return concatenated.contains(str2);
    }
}

