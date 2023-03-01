package daily.y_2023.m_01.d_29.pg_표현_가능한_이진트리;

class Solution {
    public boolean[] target; //2진법으로 변환한 배열 (좌측 0 패딩 포함
    public int result;

    //Root 부터 탐색
    public void solve(int s, int e, boolean isEnd) {
        int mid = (s + e) / 2;//루트노드의 인덱스
        boolean cur = target[mid];//루트노드의 값 : 0(false)이면 다음 순회 isEnd가 트루임

        //부모노드가 0으로 cur이 true여선 안됨(정확히는 cur 존재 불가능)
        if (isEnd && cur) {//루트노드가 없는데 자식 노드가 있다.
            result = 0;//안된당
            return;
        }
        //마지막 노드가 아닐 경우, 계속 진행
        if (s != e) {
            solve(s, mid-1, !cur);
            solve(mid+1, e, !cur);
        }
    }

    public int[] solution(long[] numbers) {
        int[] res = new int[numbers.length];
        for (int ind = 0; ind < numbers.length; ind++) {
            result = 1; //일단 된다고 가정
            long num = numbers[ind];
            //2진법 변환한 target 배열 생성
            //해당 수의 2진법 길이 계산
            int len = (int)Math.floor(Math.log(num) / Math.log(2)) + 1;
            //해당 수의 포화 이진트리 길이 계산
            int exp = 1;
            int treeLen = 0;
            while(true) {
                treeLen = (int)Math.pow(2, exp++) - 1;
                if (treeLen >= len) break;
            }

            target = new boolean[treeLen];
            int i = treeLen - 1;
            while(true) {
                long div = num / 2;
                long mod = num % 2;
                num = div;
                target[i--] = (mod == 1);
                if (div == 1) {
                    target[i] = true;
                    break;
                } else if (div == 0)
                    break;
            }
            solve(0, treeLen - 1, false);
            res[ind] = result;
        }
        return res;
    }
}