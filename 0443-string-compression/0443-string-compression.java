class Solution {
    public int compress(char[] chars) {

        char ex = chars[0];
        int cnt = 1;
        int answer=0;

        int index=0;

        int j=0;
        
        /**
        1. 같은 문자 반복 수 구한다
        2. 길이는 1 (문자)  + 숫자의 길이(10으로 나누기 + 1 )
        3. 끝까지 
         */
        
        for(int i=1;i<chars.length ; i++){
            
            if(ex==chars[i]){
                cnt++;
            }
            else{
                //숫자 설정
                answer +=1;
                int intLen= 0 ;
                if(cnt!=1){
                    intLen = (int)(Math.log10(cnt)+1);
                    answer += intLen; 
                }

                String intStr= String.valueOf(cnt);
                
                //기존 배열 수정
                chars[j++] = ex;
                for(int c= 0 ; c< intLen; c++){
                    chars[j++] = intStr.charAt(c);

                }


                cnt=1;
                ex=chars[i];
            }

        }
        
        //마지막 처리
        answer+=1;
        int intLen= 0 ;
        if(cnt!=1){
            intLen = (int)(Math.log10(cnt)+1);
            answer += intLen; 
        }

        String intStr= String.valueOf(cnt);
        
        //기존 배열 수정
        chars[j++] = ex;
        for(int c= 0 ; c< intLen; c++){
            chars[j++] = intStr.charAt(c);

        }
        
        return answer;
    }

}