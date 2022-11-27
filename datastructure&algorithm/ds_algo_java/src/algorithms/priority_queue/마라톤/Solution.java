package algorithms.priority_queue.마라톤;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = new String[record.length];
        Person[] persons = new Person[record.length];

        ArrayList<Person>[] tracks = new ArrayList[5];
        for(int i=0;i<tracks.length;i++){
            tracks[i] = new ArrayList<>();
        }


        for(int i=0;i<record.length;i++){
            Person curPerson = new Person();//현재사람

            String[] nameAndLog = record[i].split("[:]");
            String name= nameAndLog[0];//이름

            String[] logString = nameAndLog[1].split("[,]");
            int[] logs = new int[logString.length];
            for(int j=0;j<logString.length;j++){
                logs[j] = Integer.parseInt(logString[j]);//트랙별 성과
                if(logs[j]!=0) tracks[j].add(curPerson);//완주했으면 트랙에 person add
            }


            curPerson.name = name;
            curPerson.logs = logs;
            curPerson.calculate();
            persons[i] = curPerson;
        }

        for(int i=0;i<tracks.length;i++){
            rank(tracks[i],i);
        }

        PriorityQueue<Person> pq = new PriorityQueue<>();
        for(int i=0;i<persons.length;i++){
            // System.out.println("persons[i] = " + persons[i]);
            pq.offer(persons[i]);
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = pq.poll().name;
        }
        return answer;
    }
    static void rank(ArrayList<Person> trackLog,int trackNum){
        Collections.sort(trackLog, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.logs[trackNum]-o2.logs[trackNum];
            }
        });
        // System.out.println("코스 " + (trackNum+1) );
        // for(int i=0;i<trackLog.size();i++){
        //     System.out.println(trackLog.get(i).name+trackLog.get(i).logs[trackNum]);
        // }
        int goldRange = (int) Math.ceil((double) trackLog.size()/12.0);
        int silverRange = (int) Math.ceil((double) trackLog.size()/4.0);
        int bronzeRange = (int) Math.ceil((double) trackLog.size()/2.0);
        // System.out.println("bronzeRange = " + bronzeRange);
        // System.out.println("silverRange = " + silverRange);
        // System.out.println("goldRange = " + goldRange);

        for(int i=0;i<trackLog.size();i++){
            if(i+1<=goldRange) {
                // System.out.println((trackNum+1)+"번 코스"+trackLog.get(i).name+(i+1)+"위로 금메달");
                trackLog.get(i).gold++;
            }
            else if(i+1<=silverRange) {
                // System.out.println((trackNum+1)+"번 코스"+trackLog.get(i).name+(i+1)+"위로 은메달");
                trackLog.get(i).silver++;
            }
            else if(i+1<=bronzeRange) {
                // System.out.println((trackNum+1)+"번 코스"+trackLog.get(i).name+(i+1)+"위로 동메달");
                trackLog.get(i).bronze++;
            }
        }

    }
    static class Person implements Comparable<Person>{
        String name;
        int[] logs;
        int wanju;
        int highRank;

        int sumwanju=0;

        int gold = 0;
        int silver= 0;
        int bronze= 0;

        public Person(String name, int[] logs){
            this.name = name;
            this.logs = logs;
            this.wanju = 0;
            this.highRank = 0;
            calculate();
        }
        public Person(){

        }

        public void calculate(){
            for(int i=0;i<logs.length;i++){
                // System.out.println("logs[i] = " + logs[i]);
                if(logs[i]!=0){
                    // System.out.println(this.name+"wnaju++");
                    wanju++;
                    sumwanju+=logs[i];
                    highRank=i+1;
                }
            }

        }
        @Override
        public String toString(){
            String s = this.name+"\n";
            for(int i=0;i<logs.length;i++){
                s+= " "+ logs[i];
            }
            s+="\n";

            s+="wanju="+wanju+" highRank="+ highRank+
                    " gold="+gold+
                    " silver="+silver+
                    " bronze="+bronze+"\n\n";
            return s;

        }

        @Override
        public int compareTo(Person o){
            if(wanju-o.wanju!=0){//완주한거 더 많은 놈이 앞순위
                return o.wanju-wanju;
            }
            if(highRank-o.highRank!=0){//
                return o.highRank-highRank;
            }
            //메달수
            if (gold - o.gold != 0) {
                return o.gold-gold;
            }
            if (silver - o.silver != 0) {
                return o.silver-silver;
            }
            if(bronze-o.bronze!=0){
                return o.bronze-bronze;
            }

            if(sumwanju-o.sumwanju!=0){
                return sumwanju-o.sumwanju;
            }

            return name.compareTo(o.name);
        }
    }
}

//
//
// 1번 코스kevin2위로 동메달
//
//
// 2번 코스kevin1위로 은메달
//
//
// 2번 코스ted4위로 동메달
// 3번 코스kevin0위로 금메달
//
// // 3번 코스hue2위로 은메달 동
//
// 3번 코스jean4위로 동메달
//
//
// // 4번 코스hue2위로 은메달 동
// 4번 코스lala3위로 동메달
// 4번 코스jack4위로 동메달
//
// 5번 코스ted1위로 은메달
// 5번 코스lala2위로 은메달
//
// // 5번 코스elsa4위로 동메달