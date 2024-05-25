import java.util.*;

class SmallestInfiniteSet {
    //직접 힙을 만들어보는 문제. 

    private PriorityQueue<Integer> pq; //전역 변수 선언
    public SmallestInfiniteSet() { // 초기화 함수 
        pq= new PriorityQueue <>();//우선순위 큐 힙 초기화 

        for(int i=1;i<=1000;i++){
            pq.offer(i); //1~1000을 힙에 넣어주기 
        }
        
    }
    
    public int popSmallest() { //top 반환 및 제거
        return pq.poll();
    }
    
    public void addBack(int num) { //중복아닌 
        if(!pq.contains(num))
            pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */