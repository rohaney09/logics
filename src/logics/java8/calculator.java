package logics.java8;

interface cal {
    void switchin();
}

public class calculator {
    public static void main(String[] args) {

        cal c = () -> System.out.println("Hello World");

        c.switchin();
    }
}
