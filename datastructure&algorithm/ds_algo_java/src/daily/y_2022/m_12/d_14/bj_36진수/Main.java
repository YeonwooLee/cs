package daily.y_2022.m_12.d_14.bj_36진수;
import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.math.BigInteger;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String val36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException{



        //단어배열
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];//배열 생성
        //배열 초기화
        for(int i=0;i<N;i++){
            words[i] = br.readLine();
        }

        //수의 영향력
        HashMap<Character,BigInteger> map = new HashMap<>();
        for(String word:words){
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char curChar = chars[i];
                // if(curChar=='0'){
                //     map.put(curChar,map.getOrDefault(curChar,BigInteger.valueOf(0)).add(BigInteger.valueOf(0)));
                //     continue;
                // }
                BigInteger base = new BigInteger("36");
                base = base.pow(word.length()-1-i);//자릿수

                //기존값
                BigInteger original = base.multiply(BigInteger.valueOf(val36.indexOf(curChar)));
                //최댓값
                BigInteger max = base.multiply(BigInteger.valueOf(35));


                //변경영향값
                BigInteger result = max.subtract(original);

                //map에 저장
                map.put(curChar,map.getOrDefault(curChar,BigInteger.valueOf(0)).add(result));
            }
        }

        //pq에 영향값 지정하여 저장
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(char c:map.keySet()){
            pq.offer(new Num(c,map.get(c)));
        }

        //변경값 지정
        int K = Integer.parseInt(br.readLine());
        String changeString = "";
        for(int i=0;i<K;i++){
            if(pq.isEmpty()) break;
            changeString+=Character.toString(pq.poll().c);
        }
        // System.out.println("changeString = " + changeString);

        //최종결과 10진수
        BigInteger result = sum(words,changeString);
        String res = to36(result);

        System.out.println(res);

    }
    private static String to36(BigInteger num){
        String result = "";
        BigInteger thirtySix = BigInteger.valueOf(36);
        while(true){
            BigInteger mok = num.divide(thirtySix);
            BigInteger mod = num.mod(thirtySix);

            String temp = Character.toString(val36.charAt(mod.intValue()));

            result = temp+result;
            if(mok.compareTo(BigInteger.valueOf(0))==0) break;
            num =mok;
        }
        return result;


    }
    private static BigInteger sum(String[] words,String cs){
        BigInteger result = BigInteger.valueOf(0);
        for(String word:words){
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                char curChar = chars[i];
                // if(curChar=='0'){
                //     result.add(BigInteger.valueOf(0));
                //     continue;
                // }
                BigInteger base = new BigInteger("36");
                base = base.pow(word.length()-1-i);//자릿수


                //기존값
                BigInteger original = base.multiply(BigInteger.valueOf(val36.indexOf(curChar)));
                //최댓값
                BigInteger max = base.multiply(BigInteger.valueOf(35));

                if(cs.indexOf(Character.toString(curChar))>=0){
                    result = result.add(max);
                }else{
                    result = result.add(original);
                }
            }
        }
        return result;
    }
    static class Num implements Comparable<Num>{
        char c;
        BigInteger value;
        public Num(char c, BigInteger value){
            this.c = c;
            this.value = value;
        }
        @Override
        public int compareTo(Num o){
            return o.value.compareTo(this.value);
        }
    }

}
