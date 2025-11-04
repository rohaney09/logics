package logics.simplePrograms;

interface samples1 {
    default void display() {
        System.out.println("sample1");
    }
}

interface samples2 {
    default void display() {
        System.out.println("sample2");
    }
}

class cam implements samples1, samples2 {
    @Override
    public void display() {
        // Resolve diamond problem
        samples2.super.display();   // choose one interface
    }

    public static void main(String[] args) {
        cam c = new cam();
        c.display();
    }
}
