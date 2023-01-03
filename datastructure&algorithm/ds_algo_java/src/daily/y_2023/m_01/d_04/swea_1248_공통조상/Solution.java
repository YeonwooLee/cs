package daily.y_2023.m_01.d_04.swea_1248_공통조상;

import java.io.*;
import java.util.ArrayList;

public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int v,e,a,b;
    static Node[] tree;
    static boolean[] parents;

    static int result;

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            init();
//
//			for(int i=1;i<tree.length;i++) {
//				Node n = tree[i];
//				System.out.println("num="+n.num);
//				System.out.println("parent="+n.parent);
//				System.out.println("left="+n.left);
//				System.out.println("right="+n.right);
//				System.out.println("========");
//			}

            checkParentA(a);
            int commonP = checkParentB(b);
            dfs(commonP);
            bw.write("#"+tc+" "+commonP+" "+result+"\n");

        }
        bw.flush();
        bw.close();
    }
    static void dfs(int n) {
        result++;
        if(tree[n].left==-1) return;
        dfs(tree[n].left);

        if(tree[n].right==-1) return;
        dfs(tree[n].right);


    }
    static void checkParentA(int a) {
        int curP = tree[a].parent;
        if(curP==-1) return;

        parents[curP]=true;
        checkParentA(curP);

    }
    static int checkParentB(int b) {
//		System.out.println("b="+b);
        int curP = tree[b].parent;
        if(parents[curP]) return curP;

        return checkParentB(curP);

    }

    static void init() throws Exception{
        result = 0;

        String[] veab = br.readLine().split(" ");
        v=Integer.parseInt(veab[0]);
        e=Integer.parseInt(veab[1]);
        a=Integer.parseInt(veab[2]);
        b=Integer.parseInt(veab[3]);

        parents = new boolean[v+1];


        tree = new Node[v+1];
        for(int i=1;i<=v;i++) {
            tree[i]=new Node(i);
        }

        String[] edges = br.readLine().split(" ");
//		System.out.println("e="+e);
        int i=0;
        for(int k=0;k<e;k++) {
//			System.out.println("i="+i);
            int parent = Integer.parseInt(edges[i]);
            int child = Integer.parseInt(edges[i+1]);

            tree[parent].addChild(child);
            tree[child].parent=parent;
//			System.out.println(tree[parent]);
//			System.out.println(tree[child]);
            i+=2;
        }


    }

    static class Node{
        int parent;
        int num;
        int left;
        int right;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("num="+num);
            sb.append("  parent="+parent);
            sb.append("  left="+left);
            sb.append("  right="+right);
            return sb.toString();
        }
        public Node(int num) {
            this.num = num;
            this.left=-1;
            this.right=-1;
            this.parent=-1;
        }

        public void addChild(int num) throws Exception {
            if(this.left==-1) this.left=num;
            else if(this.right==-1)this.right=num;
            else throw new Exception();

        }

    }
}