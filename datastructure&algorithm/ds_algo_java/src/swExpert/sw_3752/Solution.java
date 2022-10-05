package swExpert.sw_3752;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int n,t;
    static int[] score;
    static Set<Integer> s;
    static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        t=sc.nextInt();
        for (int tc = 1; tc <=t; tc++) {
            n=sc.nextInt();
            score=new int[n];
            arr=new ArrayList<>();
            //점수 배정
            for (int i = 0; i < n; i++) {
                score[i]=sc.nextInt();
            }

            s=new HashSet<>();//가능한 점수 세트
            s.add(0);

            arr.add(0);
            dfs(0);

            System.out.printf("#%d %d\n",tc,s.size());
        }
    }
    private static void dfs(int cnt) {
        if(cnt==n) {
            return;
        }
        int len=arr.size();
        for (int i = 0; i < len; i++) {
            if(!s.contains(arr.get(i)+score[cnt])) {
                s.add(arr.get(i)+score[cnt]);
                arr.add(arr.get(i)+score[cnt]);
            }
        }
        dfs(cnt+1);
    }
}