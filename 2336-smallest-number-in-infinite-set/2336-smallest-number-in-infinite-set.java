class SmallestInfiniteSet {

    private static PriorityQueue<Integer> heap;

    //초기화. 양수를 갖는 셋을 초기화
    public SmallestInfiniteSet() {
        
        heap = new PriorityQueue<>();
        
        for(int i=1;i<=1000;i++){
            heap.add(i);
        }

    }
    
    // 가장 작은 수를 없앤다. -> 최소힙!
    public int popSmallest() {
        
        int min=heap.peek();
        heap.remove(min);
        return min;
        
    }
    
    // 수 추가 
    public void addBack(int num) {

        if(heap.contains(num)){
            return;
        }
        heap.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */