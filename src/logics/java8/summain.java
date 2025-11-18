package logics.java8;

interface sum {
    void add(int age);
}

public class summain {
    public static void main(String[] args) {
        sum m = (age) -> System.out.println(age);
        m.add(18);
    }
}

