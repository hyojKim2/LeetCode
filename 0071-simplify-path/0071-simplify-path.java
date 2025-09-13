class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/+");


        Stack<String> st = new Stack<>();
        

        for (String s : str) {
            if (s.isEmpty() || s.equals(".")) {
                continue;  // 빈 문자열과 현재 디렉토리 무시
            } else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();  // 상위 디렉토리로 이동
                }
            } else {
                st.push(s);  // 실제 디렉토리 추가
            }
        }

                
        return "/" + String.join("/", st);
    }
}