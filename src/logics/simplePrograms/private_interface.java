package logics.simplePrograms;

public interface private_interface {
    default void show1(){
        helper();
    }
    private void helper(){
        System.out.println("private helper");
    }
}
interface child {
    default void show2()
    {
        System.out.println("child");
    }
}
class z implements child,private_interface{
    public void show(){
        private_interface.super.show1();
    }
}
class Mainpro{
    public static void main(String[] args) {
        z zo = new z();
        zo.show();
    }
}
