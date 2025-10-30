package sample;

interface Aa { void methodA(); }
abstract class Bb { void methodA() {} }

class Cc extends Bb implements Aa {
    public void methodA() { System.out.println("Implemented"); }
}

public class test {
    public static void main(String[] args) {
        Cc c = new Cc();
        c.methodA();
    }
}
