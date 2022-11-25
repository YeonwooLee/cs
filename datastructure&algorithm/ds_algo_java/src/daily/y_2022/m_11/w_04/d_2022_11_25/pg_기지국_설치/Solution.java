package daily.y_2022.m_11.w_04.d_2022_11_25.pg_기지국_설치;

import java.util.ArrayList;

class Solution {
    static int area;
    static int answer = 0;
    public int solution(int n, int[] stations, int w) {
        int leftStart = 1;
        area = w*2+1;
        for(int sub:stations){
            int leftEnd = sub-w;
            if(leftStart<sub-w){
                int length = leftEnd-leftStart;
                cal(length);
            }
            leftStart = sub+w+1;
        }

        if(n>=leftStart){
            int length=n-leftStart+1;
            cal(length);

        }

        return answer;
    }
    static void cal(int length){
        answer += length/area;
        if(length%area>0) answer++;
    }
}