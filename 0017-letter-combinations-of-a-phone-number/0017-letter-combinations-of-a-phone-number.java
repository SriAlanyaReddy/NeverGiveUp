class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        Map<Character, String> phoneMap = Map.of(
    '2', "abc",
    '3', "def",
    '4', "ghi",
    '5', "jkl",
    '6', "mno",
    '7', "pqrs",
    '8', "tuv",
    '9', "wxyz"
);

        List<String>ans=new ArrayList<>();
        findCombinations(digits,phoneMap,ans,0,new StringBuilder());
        return ans;

    }
     public void findCombinations(String digits,Map<Character, String>phoneMap,  List<String>ans,int ind,StringBuilder current){
        if(ind==digits.length()){
            ans.add(current.toString());
            return;
        }
        char digit=digits.charAt(ind);
        String  letters=phoneMap.get(digit);
        for(char letter:letters.toCharArray()){
            current.append(letter);
            findCombinations(digits,phoneMap,ans,ind+1,current);
            current.deleteCharAt(current.length()-1);

        }
     }
}