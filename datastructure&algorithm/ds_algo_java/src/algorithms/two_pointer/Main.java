package algorithms.two_pointer;

public class Main {
    //N개의 요소가 있는 배열에서 연속 수열의 합이 M인 경우 찾기
    public static void main(String[] args){
        int result = 0;

        int N = 5;//배열 요소의 개수
        int M =5;//연속 수열의 합


        int[] data = {1,2,3,2,5};
        int summary = 0;
        int end =0;

        for(int start = 0;start<N;start++){
            //요소의 합이 연속수열의 합보다 작다; 끝인덱스가 배열의 길이보다 작다
            while (summary<M && end<N){
                summary += data[end];
                end++;
            }

            if(summary == M){
                result ++;
            }
            summary-=data[start];
        }

        System.out.println(result);
    }

}
