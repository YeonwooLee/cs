package hash.pg_베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Gen implements Comparable<Gen>{
    String gen;
    int play;
    PriorityQueue<Song> list;
    public Gen(String gen,int play){
        this.gen = gen;
        this.play = play;
        this.list = new PriorityQueue<>();
    }
    @Override
    public int compareTo(Gen o){
        return o.play - play;
    }
}
class Song implements Comparable<Song>{
    int title;
    int play;
    public Song(int title, int play){
        this.title = title;
        this.play = play;

    }
    @Override
    public int compareTo(Song o){
        return o.play-play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        int idx =0;
        HashMap<String,Gen> map = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            Gen now = map.getOrDefault(genres[i],new Gen(genres[i],0));
            now.play+=plays[i];
            map.put(genres[i],now);
            map.get(map.get(genres[i]).list.offer(new Song(i,plays[i])));
        }

        PriorityQueue<Gen> gens = new PriorityQueue<>();
        for(String s:map.keySet()){
            gens.offer(map.get(s));//우선순위큐에 각 장르 입력
        }
        while(!gens.isEmpty()){
            Gen g = gens.poll();
            int times=0;
            while(!g.list.isEmpty()){
                // System.out.println(g.list.poll().title);
                result.add(g.list.poll().title);
                // times++;
                if(++times>=2) break;
            }
        }
        int[] res = new int[result.size()];
        for(int i:result){
            res[idx++]=i;
        }
        return res;
    }
}