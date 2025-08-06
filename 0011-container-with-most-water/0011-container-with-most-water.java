class Solution {
    public int maxArea(int[] height) {

        // two pointer 

        int x= 0;
        int y= 0; 
        int answer = 0;


        int right  = height.length -1 ;
        int left = 0;

        // 투포인터로 양끝을 줄이되, 이동 방법은 left, right 좌표 중,둘 중 높이가 더 큰 쪽에서 다음 기둥과 높이 차이가 작은 쪽으로 이동함. 가로 길이는 작아지고, 높이에 변화가 생기는 것이 핵심임. 이 방법으로 구할 수 있음! 
        //추가로 배열은 단순 필드 데이터라 .length, 문자열과 리스트는 컬렉션이기에 length()   & size() 메서드를 사용해 크기 구함.  

        while( left < right){
            x = right-left;
            y= Math.min(height[right], height[left]);

            int nowWater = x * y ;

            if(nowWater > answer){
                answer=nowWater;
            }

            if(height[right] > height[left]){
                int next= left++;
                while( height[left] <height[next]){
                    next++;
                }

            }
            else{
                int next= right--;
                while( height[right] <height[next]){
                    next--;
                }

            }
        }



        return answer;




 

        
    }
}