package daily.y_2022.m_11.w_04.d_2022_11_26.지하철;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void 솔류션(){
        //given
        Solution s = new Solution();
        String[] subway = {"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"};
        int start = 1;
        int end = 9;
        //when

        // then
        System.out.println(s.solution(subway,start,end));
    }

}