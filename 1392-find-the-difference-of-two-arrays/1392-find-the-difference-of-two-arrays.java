class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashSet<Integer> list1= includeNum(nums1);
        HashSet<Integer> list2 = includeNum(nums2);

        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        // list1 - list2
        HashSet<Integer> diff1 = new HashSet<>(list1);
        diff1.removeAll(list2);

        // list2 - list1
        HashSet<Integer> diff2 = new HashSet<>(list2);
        diff2.removeAll(list1);

        answer.add(new ArrayList<>(diff1));
        answer.add(new ArrayList<>(diff2));

        return answer;
        
    }

    public HashSet<Integer> includeNum(int[] nums){
        HashSet<Integer> includeList = new HashSet<>();

        for(int num:nums){
            includeList.add(num);
        }

        return includeList;
    }
}