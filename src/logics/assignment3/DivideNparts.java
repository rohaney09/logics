package logics.assignment3;

public class DivideNparts {
    public static void main(String[] args) {
            String str = "Hello World Java";
            str = str.replace(" ", "");

            int parts = 5;
            int len = str.length();
            int size = len / parts;
            int start = 0;

            for (int i = 0; i < parts; i++) {
                int end = start + size;

                if (i == parts - 1) {
                    end = len;
                }

                System.out.println("Part " + (i + 1) + ": " + str.substring(start, end));
                start = end;
            }
    }
}
