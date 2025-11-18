
package logics.java8;

interface mul {
    int multi(int x, int y);
}

public class multiplay {
    public static void main(String[] args) {
        mul m = (x,y) -> x * y;
        System.out.println(m.multi(2,18));
    }
}
