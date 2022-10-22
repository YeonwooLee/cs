package dfs.pg_단어_변환;

import java.util.Queue;
import java.util.LinkedList;
class Node{
    String word;
    int dist;
    public Node(String word,int dist){
        this.word = word;
        this.dist = dist;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {

        return bfs(begin,target,words);
    }

    static int bfs(String begin, String target, String[] words){
        int len = words.length;
        boolean[] visited = new boolean[len];

        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(begin,0));

        while(!q.isEmpty()){
            Node curNode = q.poll();
            String curWord = curNode.word;
            int curDist = curNode.dist;
            if(curWord.equals(target)) return curDist;

            for(int i=0;i<len;i++){
                if(visited[i]) continue;
                if(dist1(curWord,words[i])){
                    visited[i]=true;
                    q.offer(new Node(words[i],curDist+1));
                }
            }
        }
        return 0;
    }

    //
    static boolean dist1(String a, String b){
//         int[] chars = new int[(int)('z'-'a')+1];
        int count = 0;

//         for(int i=0;i<a.length();i++){
//             chars[(int)(a.charAt(i)-'a')]=1;
//         }
//         for(int i=0;i<b.length();i++){
//             if(chars[(int)(b.charAt(i)-'a')]!=1) count++;
//         }
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) count++;
        }
        return count==1;
    }
}