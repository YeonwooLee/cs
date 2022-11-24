package daily.y_2022.m_11.w_04.d_2022_11_24.pg_3차_파일명_정렬;

import java.util.Arrays;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] fileArray = new File[files.length];


        for(int i=0;i<files.length;i++){
            fileArray[i] = filization(files[i]);
            fileArray[i].idx = i;
        }
        Arrays.sort(fileArray);
        for(int i=0;i<fileArray.length;i++){
            answer[i]=fileArray[i].toString();
        }
        return answer;
    }
    static File filization(String s){
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        boolean numberFlag = false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){
                number.append(c);
                numberFlag = true;
                continue;
            }
            if(numberFlag){
                tail.append(s.substring(i));
                break;
            }else{
                head.append(c);
            }
        }

        return new File(head.toString(),Integer.parseInt(number.toString()),tail.toString(),number.toString());
    }


    static class File implements Comparable<File>{
        String head,tail,numString;
        int number,idx;

        public File(String head, int number, String tail,String numString){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.numString = numString;
        }

        @Override
        public int compareTo(File o){
            //헤드가 다르면 사전순
            if(!head.equalsIgnoreCase(o.head)){
                return head.toLowerCase().compareTo(o.head.toLowerCase());
            }
            //헤드가 같으면 넘버 비교
            if(number!=o.number){
                return number-o.number;
            }
            return idx-o.idx;



        }
        @Override
        public String toString(){
            return head+numString+tail;
            // return "head="+head+"\nnumber="+number+"\ntail="+tail+"\n\n";
        }
    }
}