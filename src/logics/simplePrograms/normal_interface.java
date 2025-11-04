package logics.simplePrograms;

interface sam1 {
    void display() ;
}

interface sam2 {
    void display2();
}

class came implements sam1, sam2 {

    public void display() {
        System.out.println("display 1");
    }

    public void display2() {
        System.out.println("display 2");
    }

    public static void main(String[] args) {
        came c = new came();
        c.display();
        c.display2();
    }
}
