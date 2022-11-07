package daily.y_2022.m_10.w_03.d_2022_10_12.pg_여행경로;

class Solution {
    static String result="";

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];
        dfs("ICN",tickets,tickets.length,1,visited,"ICN");
        return result.split(" ");
    }

    static void dfs(String start, String[][] tickets,int len, int depth,boolean[] visited,String res){
        if(depth==len+1){
            // System.out.println(res);
            if(result.length()==0) result = res;
            else{
                //res vs result
                if(res.compareTo(result)<0){
                    result = res;
                }

            }
            return;
        }

        for(int i=0;i<tickets.length;i++){
            String s = tickets[i][0];
            String e = tickets[i][1];

            if(!s.equals(start)) continue;//출발지 다름
            if(visited[i]) continue;//방문
            visited[i]= true;
            dfs(e,tickets,len,depth+1,visited,res+" "+e);
            visited[i]=false;

        }
    }
}