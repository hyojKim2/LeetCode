import java.util.*;

class SeatManager {

    static PriorityQueue<Integer> pQ ;
    
    public SeatManager(int n) {
        
        pQ = new PriorityQueue<>(); //큐 초기화
        for(int i=0;i<n;i++)
            pQ.offer(i+1);
        
    }
    
    public int reserve() {
        return  pQ.poll();
    }
    
    public void unreserve(int seatNumber) {
        pQ.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */