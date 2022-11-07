package daily.y_2022.m_10.w_02.d_2022_10_06.pg_타겟_넘버;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers,target,0,0, " ");
        return answer;
    }
    static void dfs(int[] numbers,int target, int depth,int sum,String temp){
        if(depth==numbers.length){
            if(sum==target){
                // System.out.println(temp);
                answer ++;
            }
            return;
        }
        dfs(numbers,target,depth+1,sum+numbers[depth],temp+ " 1");
        dfs(numbers,target,depth+1,sum-numbers[depth],temp+" 0");

    }
}