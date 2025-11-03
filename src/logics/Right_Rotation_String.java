package logics;

public class Right_Rotation_String {
    public static void main(String[] args) {
        String s = "abcdef";
        int r = 2;

        System.out.println("Before rotation: " + s);
        System.out.println("After right rotation: " + rotateRight(s, r));
    }

    static String rotateRight(String s, int r) {
        int n = s.length();
        r = r % n; // handle if r > n

        // take last 'r' characters + remaining first part
        String rotated = s.substring(n - r) + s.substring(0, n - r);
        return rotated;
    }
}
