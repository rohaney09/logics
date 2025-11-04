package logics.assignment2;

public class CountPunctuations {
    public static void main(String[] args) {
        String str = "Hey I'm Rohan Paul, Software Developer!";

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '!' || ch == ',' || ch == ';' || ch == '.' ||
                    ch == '?' || ch == '-' || ch == '\'' || ch == '\"') {
                count++;
            }
        }
        System.out.println(count);
    }}




