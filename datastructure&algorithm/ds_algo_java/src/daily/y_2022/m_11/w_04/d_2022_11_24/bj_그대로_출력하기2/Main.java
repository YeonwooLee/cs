package daily.y_2022.m_11.w_04.d_2022_11_24.bj_그대로_출력하기2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String NEW_LINE = "\n";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp = br.readLine()) != null) {
            sb.append(temp).append(NEW_LINE);
        }
        System.out.println(sb.toString());
    }
}
