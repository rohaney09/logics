package logics.assignment4;

public class demo {
    int a;
    demo() {
        this.a = 1;

    }
    demo(int x){
        this();
    }
    public static void main(String[] args) {
        demo d = new demo();
        System.out.println(d.a);

    }
}
