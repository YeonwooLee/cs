package daily.y_2022.m_11.w_01.d_2022_11_04.pg_단속카메라;

import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        });

        int lastCamera = -30001;
        int count =0;
        for(int[] cur: routes){
            int start = cur[0];
            int end = cur[1];

            if(lastCamera>=start) continue;
            lastCamera = end;
            count++;
        }
        return count;
    }
}