package algorithms.string.pg_숫자_짝궁_2회차;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //map 구성 완료
        for(int i=0;i<X.length();i++){
            //지금 뽑으려는 수
            int num = Integer.parseInt(X.substring(i,i+1));
            //맵에 지금 뽑으려는 수 몇개?
            int cur = map.getOrDefault(num,0);

            map.put(num,cur+1);
        }

        for(int i=0;i<Y.length();i++){
            //확인할 수
            int num = Integer.parseInt(Y.substring(i,i+1));

            //있나 확인
            int cur = map.getOrDefault(num,0);

            //있으면 한개 빼고 pq에 추가
            if(cur>0){
                list.add(num);
                map.put(num,cur-1);
            }
        }
        if(list.size()==0){
            return "-1";
        }
        Collections.sort(list,new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<list.size();i++){
            if(i==0 && list.get(i)==0) return "0";
            sb.append(Integer.toString(list.get(i)));
        }

        return sb.toString();

    }
}