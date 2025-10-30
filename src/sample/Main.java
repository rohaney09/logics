package sample;

 interface A {
        default void greet1() {
            System.out.println("Hello from default method! A");
        }
    }

interface B {
    default void greet2() {
        System.out.println("Hello from default method! B");
    }
}


class C implements A,B {

    }

    public class Main {
        public static void main(String[] args) {
            C obj = new C();
            obj.greet1();
        }
    }

