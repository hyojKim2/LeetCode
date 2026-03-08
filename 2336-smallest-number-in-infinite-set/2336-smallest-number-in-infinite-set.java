class SmallestInfiniteSet {

    private PriorityQueue<Integer> heap;
    private HashSet<Integer> set;
    private int current; // 1~1000이 들은 것처럼 가정하는 변수 

    //초기화. 양수를 갖는 셋을 초기화
    public SmallestInfiniteSet() {
        
        heap = new PriorityQueue<>();
        set =new HashSet<>();
        current = 1;
        

    }
    
    // 가장 작은 수를 없앤다. -> 최소힙!
    public int popSmallest() {
        if(!heap.isEmpty()){
            set.remove(heap.peek());
            return heap.poll();
        }
        
        return current++;
    }
    
    // 수 추가 
    public void addBack(int num) {

        if(num < current && !set.contains(num)){
            set.add(num);
            heap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */