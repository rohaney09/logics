package logics.java8;


interface mull {
    int multi(int x, int y);
}

public class multiException {
    public static void main(String[] args) {
        mul m = (x,y) -> {
            if(x>y){
                throw  new ArithmeticException("Pagal");
            }else{
                return x*y;
            }
        };
        System.out.println(m.multi(2,18));
    }
}

