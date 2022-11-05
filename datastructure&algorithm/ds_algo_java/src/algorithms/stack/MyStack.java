package algorithms.stack;

import java.util.ArrayList;

public class MyStack<T> {
    ArrayList<T> list;
    public int top;
    public MyStack(){
        this.top = -1;
        list = new ArrayList<>();
    }
    public T pop(){
        T val = list.get(top);
        list.remove(top);
        top--;
        return val;
    }

    public int push(T val){
        list.add(val);
        top++;
        return top;
    }


}
