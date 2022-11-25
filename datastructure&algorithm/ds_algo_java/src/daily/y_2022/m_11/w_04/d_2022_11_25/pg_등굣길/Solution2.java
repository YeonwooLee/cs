package daily.y_2022.m_11.w_04.d_2022_11_25.pg_등굣길;
//2차시도 - 정답
class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];//행렬생성
        for(int[] puddle:puddles){
            map[puddle[0]][puddle[1]]=-1;//못 -1로
        }
        int mod = 1_000_000_007;
        int answer = 0;
        map[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j]==-1) continue; //연못밴

                //연못 아니면
                //행빼기가능하고 값이 -1이 아니면
                if(i-1>0&&map[i-1][j]!=-1){
                    map[i][j]+=map[i-1][j]%mod;
                }
                //열빼기 가능하고 값이 -1이 아니면
                if(j-1>0 &&map[i][j-1]!=-1){
                    map[i][j]+=map[i][j-1]%mod;
                }
            }
        }
        answer = map[m][n]%mod;
        return answer;

    }
}