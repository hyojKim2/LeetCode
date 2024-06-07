import java.util.*;
/*
1. 해시맵을 선언해 <String , Integer[]>에 < [a, e, i, o, u]에 해당하는 각 문자: 50 크기의 배열에 key 문자가 만들 수 있는 idx+1 크기 문장수>에 저장한다.
2. 문장 길이가 n일때, 각 문자(인덱스 i)가 가질 수 있는 문장의 수는, 문자~키끝까지의 각 value에서 [n-1]인덱스에 해당하는 integer의 합계다.
3. n이 1인 경우를 초기세팅하고, 2부터 n까지 작은 것부터 map을 업데이트
4. 해당하는 값을 map에서 찾아 반환
*/

class Solution {

    
    static Map<String, Integer[]> memo;  // 메모이제이션을 위한 맵
    static List<String> aeiou = Arrays.asList("a", "e", "i", "o", "u");

    public int countVowelStrings(int n) {

        memo=new HashMap<>(); //초기화

        for(String chr : aeiou){
            Integer[] valueArray = new Integer[50];
            valueArray[0]=1;
            memo.put(chr, valueArray); //초기세팅 
        }

        //System.out.println(memo.get('o'));
        
        for(int i=2 ; i<=n;i++){
            for(String chr : aeiou){
                lexicoSort(i, chr); //
            }
        }
        
        int sum=0;

        for(String chr : aeiou){
            Integer[] valueArray = memo.get(chr);
            sum+=valueArray[n-1];
        }
        return sum;
    }

    static public void lexicoSort(int n, String startChar){
        int cnt=0;
        boolean start = false;
        for( String chr : aeiou){
            if(chr.equals(startChar)){
                start=true;// 접근    
            }
            if(start){
                Integer[] valueArray = memo.get(chr); //chr의 key 값 저장
                cnt+=valueArray[n-2]; //해당하는 값 가져와 더함 
            }
        }
        Integer[] valueArray = memo.get(startChar); //startChar의 key 값 복사하여 저장
        valueArray[n-1]=cnt; // n길이일때 가질 수 있는 문장 수 저장
        memo.put(startChar,valueArray ); //맵 갱신
    }
}