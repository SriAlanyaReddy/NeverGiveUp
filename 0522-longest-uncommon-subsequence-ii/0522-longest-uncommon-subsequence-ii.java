class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,(a,b)->b.length()-a.length());
        int n=strs.length;
        for(int i=0;i<n;i++){
            boolean isUncommon=true;
            for(int j=i+1;j<n;j++){
                if(i!=j && issubsequence(strs[i],strs[j])){
                   isUncommon=false;
                   break;

                }


            }
            if(isUncommon) return strs[i].length();
        }
        return -1;
    }
    public boolean issubsequence(String s1,String s2){
        int i=0,j=0;
        while(i<s1.length() && j<s2.length() ){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s1.length();
    }
}