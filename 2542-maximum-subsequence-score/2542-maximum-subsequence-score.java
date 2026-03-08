class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        /**
        num2 기준 내림차순, 
        num1합을 최대화 
         */

        int n = nums1.length;

        int[][] pair = new int[n][2];

        for(int i=0;i<n;i++){
            pair[i][0] = nums2[i];
            pair[i][1] = nums1[i];
        }

        Arrays.sort(pair,(a,b)->b[0]-a[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long sum = 0;
        long res = 0;

        for(int[] p : pair){

            heap.add(p[1]);
            sum += p[1];

            if(heap.size() > k){
                sum -= heap.poll();
            }

            if(heap.size() == k){
                res = Math.max(res, sum * p[0]);
            }
        }

        return res;
    }
}