class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int[] occur = new int[2001];

        for(int ar: arr){
            occur[ar+1000]+=1;
        }

        HashSet<Integer> set = new HashSet<>(); //발생 횟수

        int occCnt=0;
        for(int occ:occur){
            if(occ!=0){
                set.add(occ);
                occCnt++;
            }
        }

        if(occCnt==set.size()){
            return true;
        }
        return false;


        
    }
}