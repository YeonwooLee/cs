package algorithms.string.pg_숫자짝궁;


class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        for(int i=0;i<X.length();i++){
            arrX[Integer.parseInt(X.substring(i,i+1))]++;
        }
        for(int i=0;i<Y.length();i++){
            arrY[Integer.parseInt(Y.substring(i,i+1))]++;
        }

        String result = "";
        for(int i=9;i>=0;i--){
            for(int j=0;j<Math.min(arrX[i],arrY[i]);j++){
                sb.append(Integer.toString(i));
                // result +=Integer.toString(i);
            }
        }
        if(sb.toString().equals("")) return "-1";
        if(sb.toString().startsWith("0")) return "0";
        else{
            return sb.toString();
        }

    }
}