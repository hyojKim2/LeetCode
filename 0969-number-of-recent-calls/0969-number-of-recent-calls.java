import java.util.*;

class RecentCounter {

    //Queue<Integer> queue = new LinkedList<>();

    List<Integer> list  = new ArrayList<>();


    public RecentCounter() {
        list =new ArrayList<>();
        
    }
    
    public int ping(int t) {
        list.add(t);

        int cnt=0;

        for(int num : list){
            if(num>= t-3000 && num <=t){
                cnt++;
            }
            else if(num>t){
                return cnt;
            }
        }

        return cnt;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */