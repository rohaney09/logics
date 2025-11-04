package logics.simplePrograms;

public class vowelReplace {
    public static void main(String[] args) {
        String input = "Hello World";
        String output = input.replaceAll("[^AEIOUaeiou]", "*");
        System.out.println("Original: " + input);
        System.out.println("Replaced: " + output);
    }
}
