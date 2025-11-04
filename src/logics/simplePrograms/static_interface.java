package logics.simplePrograms;

interface demo1{
    static void display(){
        System.out.println("display 1");
    }
}
interface demo2 extends  demo1{
    static void display(){
        System.out.println("display 2");
    }

}
class demo3 implements  demo1,demo2{
    static void displayes(){
        demo2.display();
        System.out.println("display 3");
    }
}
class Main2{
    public static void main(String[] args) {
        demo2.display();
    }
}