package sample;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class exception {

    public static void main(String[] args) {
            try {
                FileReader fr = new FileReader("abc.txt"); // compile time exception
            }catch (FileNotFoundException e1){
                System.out.println("File ");
            }catch (Exception e) {
                System.out.println("File not found!");
            }
    }
}


