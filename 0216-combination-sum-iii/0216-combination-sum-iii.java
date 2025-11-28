import java.util.*;


class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum3(int k, int n) {

        //k개의 숫자의 합이 n인 것을 찾는다. 
        // 2<= k <=9

        answer= new ArrayList<>();

        dfs(1, 0, new ArrayList<>(), n, k);

        return answer;

        
    }

    public void dfs(int start, int sum, List<Integer> list,  int ans, int target){
        
        if(list.size()==target){
            if(sum==ans && !answer.contains(list)) {
                answer.add(new ArrayList<>(list));
            }
            return;            
        }


        for(int i=start;i<=9;i++){
            if(!list.contains(i)){ //사용되지 않은 자연수만
                list.add(i);
                dfs(i+1, sum+i, list, ans, target);
                list.remove(list.size()-1);
            }
        }

    }

    
}