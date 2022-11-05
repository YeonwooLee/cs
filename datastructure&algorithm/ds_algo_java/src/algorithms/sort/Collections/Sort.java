package algorithms.sort.Collections;
import java.util.*;

public class Sort {
    public static void main(String[] args){
        Node n1 = new Node("abc",1);
        Node n2 = new Node("cabc",2);
        Node n3 = new Node("babc",3);
        Node n4 = new Node("adbc",4);

        Node[] arr = new Node[4];
        arr[0] = n1;
        arr[1] = n2;
        arr[2] = n3;
        arr[3] = n4;

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].a+" "+arr[i].b);
        }
    }

    static class Node implements Comparable<Node>{

        String a;
        int b;
        public Node(String a, int b){
            this.a = a;
            this.b = b;
        }

        public int compareTo(Node o){
            return this.a.compareTo(o.a);
        }
    }
}
