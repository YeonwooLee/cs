package daily.y_2023.m_02.d_19.bj_창고다각형;
import java.io.*;

import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] arr;

    //좌끝과 우끝
    static int minL = Integer.MAX_VALUE;
    static int maxL = Integer.MIN_VALUE;

    //좌포인터 우포인터
    static int minPointer = Integer.MAX_VALUE;
    static int maxPointer = Integer.MIN_VALUE;

    static PriorityQueue<Pilar> pq = new PriorityQueue<>();
    static ArrayList<Pilar> use = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        Pilar[] arr = new Pilar[n];


        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            pq.offer(new Pilar(l,h));

            //좌끝우끝세팅
            if(l<minL) minL = l;
            if(l>maxL) maxL = l;
        }

        while(minPointer>minL || maxPointer<maxL){
            Pilar pilar = pq.poll();
            if(pilar.l<minPointer || pilar.l>maxPointer){
                use.add(pilar);
                if(pilar.l<minPointer) minPointer = pilar.l;
                if(pilar.l>maxPointer) maxPointer = pilar.l;
            }
        }

        use.sort(new Comparator<Pilar>(){
            @Override
            public int compare(Pilar p1, Pilar p2){
                return p1.l-p2.l;
            }
        });
        // for(Pilar s:use){
        //     System.out.println(s);
        // }

        boolean modeUp = true;
        int result = 0;
        for(int i=0;i<use.size()-1;i++){
            Pilar cur = use.get(i);
            Pilar next = use.get(i+1);

            if(cur.h>next.h){
                modeUp = false;
            }

            if(modeUp){
                result += cur.h*(next.l-cur.l);
            }else{
                result += cur.h;
                result += next.h * (next.l-cur.l-1);
            }
        }
        result += use.get(use.size()-1).h;
        System.out.println(result);





    }

    static class Pilar implements Comparable<Pilar>{
        int l,h;

        public Pilar(int l, int h){
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Pilar o) {
            return -(this.h - o.h);
        }

        @Override
        public String toString(){
            return "l="+this.l+" h="+this.h;
        }
    }
}
