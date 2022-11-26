package daily.y_2022.m_11.w_04.d_2022_11_26.pg_보석_쇼핑;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<gems.length;i++){
            int val = map.getOrDefault(gems[i],0);
            map.put(gems[i],val+1);
        }

        int s = 0;
        int e = gems.length-1;

        while(true){
            int val = map.get(gems[e]);
            if(val-1<=0) break;
            map.put(gems[e],val-1);
            e--;
        }

        while(true){
            int val = map.get(gems[s]);
            if(val-1<=0) break;
            map.put(gems[s],val-1);
            s++;
        }
        answer[0] = s+1;
        answer[1] = e+1;

        int len = e-s;

        while(true){
            HashMap<String,Integer> tempMap = new HashMap<>();
            for(String key:map.keySet()){
                tempMap.put(key,0);
            }
            int[] checkMore = screening(gems,len,tempMap);
            for(int i=0;i<checkMore.length;i++){
                System.out.printf("%2d",checkMore[i]);
                System.out.println();
            }
            if(checkMore[0]==-1) break;

            answer[0] = checkMore[0];
            answer[1] = checkMore[1];

            len--;
            if(len<=0) {
                answer= new int[]{1,1};
                break;
            }
            

        }
        return answer;
    }

    public static int[] screening(String[] gems,int len, HashMap<String,Integer> map){
        System.out.println("map = " + map);
        System.out.println("len = " + len);
        if(len==0) return new int[] {1,1};
        for(int i=0;i<len;i++){
            int val =  map.getOrDefault(gems[i],0);
            map.put(gems[i],val+1);

        }
        System.out.println("map = " + map);
        int s = 0;
        int e = len-1;
        while(e<gems.length){
            boolean isOk = mapcheck(map);
            if(isOk) return new int[]{s+1,e+1};
            System.out.println("s = " + s+ " E = "+e);
            // System.out.println("e = " + e);
            map.put(gems[s],map.get(gems[s])-1);
            s+=1;

            map.put(gems[e],map.get(gems[e])-1);
            e+=1;

        }
        return new int[]{-1,-1};

    }

    public static boolean mapcheck(HashMap<String,Integer> map){
        for(String key:map.keySet()){
            if(map.get(key)<=0) return false;
        }
        return true;
    }
}
