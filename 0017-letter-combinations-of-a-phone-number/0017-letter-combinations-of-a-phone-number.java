import java.util.*;

class Solution {

    private static final String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) return result;

        dfs(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void dfs(String digits, int index, StringBuilder path, List<String> result) {

        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0']; // 아스키코드 mm- 48 빼준 결과. 

        for (char c : letters.toCharArray()) {

            path.append(c);

            dfs(digits, index+1, path, result );

            //backtracking
            path.deleteCharAt(path.length()-1);

        }

    }
}