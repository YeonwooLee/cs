package daily.test;
import java.util.*;
public class Test {
    public static void main(String[] args){
        HashSet<String> a = new HashSet<>();
        a.add("2");
        
        
        HashSet<String>b = (HashSet<String>) a.clone();
        b.add("22");

        System.out.println("a.size() = " + a.size());
        System.out.println("b.size() = " + b.size());
    }
    void koko(){
        kaka();
    }

    void kaka(){
        System.out.println("kaka");
    }

}
