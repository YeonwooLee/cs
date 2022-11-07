package daily.y_2022.m_10.w_03.d_2022_10_15.pg_이중우선순위큐;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();

        for(String s:operations){
            String code = s.split(" ")[0];
            String order = s.split(" ")[1];
            if(code.equals("I")){
                add(Integer.parseInt(order), list);
            }else{
                if(order.equals("-1")) removeMin(list);
                else removeMax(list);
            }
        }
        if(list.size()==0) return new int[] {0,0};
        else return new int[] {list.get(list.size()-1),list.get(0)};
    }

    static void add(int num,ArrayList<Integer> list){
        list.add(num);
        Collections.sort(list);
    }

    static void removeMin(ArrayList<Integer> list){
        if(list.size()==0) return;
        list.remove(0);
    }
    static void removeMax(ArrayList<Integer> list){
        if(list.size()==0) return;
        list.remove(list.size()-1);
    }
}