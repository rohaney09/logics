package logics.simplePrograms;

interface sample1 {
    default void display1(){
        System.out.println("sample1");
    }
}

interface sample2{
    default void display(){
        System.out.println("sample2");
    }
}

class com implements sample1,sample2{
    public void display2() {
        sample2.super.display();
    }
}

class mainclass{
    public static void main(String[] args) {
        com c = new com();
        c.display();
    }
}
