class Solution {
    public String reverseVowels(String s) {
        
        //인덱스 저장
        List<Integer> indexes = new ArrayList<>();

        //문자 저장
        List<Character> targets = new ArrayList<>();

        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
        ));

        char[] answer = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if( vowels.contains(s.charAt(i))){
                indexes.add(i);
                targets.add(s.charAt(i));
            }
            answer[i]=s.charAt(i);
        }

        int size = indexes.size()-1;
        for( int index: indexes){
            answer[index] = targets.get(size--);
        }

        return new String(answer);


    }
}