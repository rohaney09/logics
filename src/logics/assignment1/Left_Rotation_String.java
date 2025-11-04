package logics.assignment1;

public class Left_Rotation_String {
    public static void main(String[] args) {
        String s = "abcdef";
        int r = 2;

        System.out.println("Before rotation: " + s);
        System.out.println("After rotation:  " + solution(s, r));
    }

    static String solution(String s, int r) {
        int n = s.length();
        r = r % n; // handle if r > n

        String rotated = s.substring(r) + s.substring(0, r);
        return rotated;
    }
}

