package logics.simplePrograms;

interface MyInterface {
        void show();
    }
public class lamda {
    public static void main(String[] args) {
        MyInterface ob = () -> System.out.println("Hello from Lambda!");
        ob.show();
    }
}
