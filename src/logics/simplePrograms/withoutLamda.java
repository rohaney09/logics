package logics.simplePrograms;


interface MyInterface1 {
    void show();
}

public class withoutLamda {
    public static void main(String[] args) {

        MyInterface ob = new MyInterface() {

            public void show() {
                System.out.println("Hello from Anonymous Class!");
            }
        };ob.show();
    }
}

