import java.util.*;

class Solution {
    
    static int [] shipWeights;
    public int shipWithinDays(int[] weights, int days) {
        
        shipWeights=weights;
        
        int left=Arrays.stream(weights).max().orElseThrow(); //최소는 weight에서 가장 큰 원소 
        int right= Arrays.stream(shipWeights).sum(); //weights의 원소 총계
        
        int mid=0;
        int answer=0;
        
        while(left<=right){
            mid=(left+right)/2;
            
            //capacity(mid)에 대한 weight들의 묶음 하나를 패키지라하자. pack는 days와 같아야한다.
            int pack=shipPackage(mid);
            System.out.println(pack);

            //days가 pack 이상이면, mid(capacity)를 작게해야 한다는 것. 
            //최소 capacity를 구해야함. 

            if( days>=pack){
                right=mid-1;
                answer=mid;
            }
            else{
                left=mid+1;
            }
            
            
        }
        
        return answer;
        
    }
    
    public int shipPackage(int capacity){ //주어진 capacity에 대해 weights의 묶음 개수를 구한다. 
        
        int pack=1;
        int sum=0;
        for(int weight: shipWeights){
            if(sum + weight  <= capacity){ //중량의 합이 capacity 이하면 더하기 
                sum+=weight;
            }
            else{
                sum=weight;
                pack++;
            }
        }
        System.out.println(capacity+ " "+ pack);
        return pack;
    }
}