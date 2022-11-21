package algorithms.union_find.bj_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] parent;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//사람 수
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        int m = Integer.parseInt(st.nextToken());//파티 수

        st = new StringTokenizer(br.readLine());//진실을 아는 사람과 번호
        int num = Integer.parseInt(st.nextToken());
        for(int i=0;i<num;i++){//진실자 부모 0으로
            parent[Integer.parseInt(st.nextToken())]=0;
        }

        ArrayList<Integer>[] parties = new ArrayList[m];
        boolean[] visited = new boolean[parties.length];
        for(int i=0;i<m;i++){
            parties[i]=new ArrayList<>();//파티초기화
            st = new StringTokenizer(br.readLine());//파티목록
            int participant = Integer.parseInt(st.nextToken());//참가인원
            for(int j=0;j<participant;j++){//파티에 참가인원 넣기
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
            if(containTrue(parties[i])){//진실자가있으면
                visited[i] = true;
                makeTrueman(parties[i]);//모든참여자 부모 0으로
            }
        }
        int count =0;

        while(true){
            boolean flag = false;
            for(int i=0;i<parties.length;i++){
                ArrayList<Integer> arr = parties[i];
                if(visited[i]) continue;
                if(containTrue(arr)){
                    makeTrueman(arr);
                    visited[i]=true;
                    flag=true;
                }
            }
            if(!flag) break;
        }

        for(boolean b:visited){
            if(!b) count++;
        }
        System.out.println(count);


    }
    static void makeTrueman(ArrayList<Integer>arr){
        for(int i:arr){
            parent[i] = 0;
        }
    }

    static boolean containTrue(ArrayList<Integer> arr){
        for(int i:arr){
            if(findParent(i)==0) return true;
        }
        return false;
    }
    static void union(int a,int b){
        a= findParent(a);
        b = findParent(b);
        if(a==b) return;

        if(a<b){
            parent[b]=a;
        }else{
            parent[a]=b;
        }
    }

    static int findParent(int n){
        if(parent[n]==n){
            return parent[n];
        }

        parent[n]=findParent(parent[n]);
        return parent[n];
    }
}
