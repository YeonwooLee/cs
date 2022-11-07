package daily.y_2022.m_11.w_01.d_2022_11_02.pg_불량_사용자;
import java.util.HashSet;

class Solution {
    static boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        HashSet<String> set = new HashSet<>();
        dfs(user_id, banned_id,0,set);
        return result.size();
    }
    private void dfs(String[] user_id, String[] banned_id,int banIdx,HashSet<String> set){

        if(banIdx==banned_id.length){
            result.add(set);
            return;
        }

        String nowBanId = banned_id[banIdx];//현재 밴 아이디
        for(int i=0;i<user_id.length;i++){
            if(visited[i]) continue;
            String nowUserId = user_id[i];//현재 유저 아이디

            //둘이 체크됨
            if(check(nowUserId,nowBanId)){
                HashSet<String> temp = (HashSet<String>)set.clone();
                visited[i] = true;
                temp.add(nowUserId);
                dfs(user_id,banned_id,banIdx+1,temp);
                visited[i]=false;
            }
        }
    }

    private boolean check(String t, String o){
        int len = t.length();
        if(len!=o.length()) return false;

        for(int i=0;i<len;i++){
            if(t.charAt(i) ==o.charAt(i)) continue;
            if(o.charAt(i)=='*') continue;
            return false;
        }
        return true;

    }
}