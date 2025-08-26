class Solution {
    public int compareVersion(String version1, String version2) {
        String s1[]=version1.split("\\.");
        int n1=s1.length;
        String s2[]=version2.split("\\.");
        int n2=s2.length;
        int i=0,j=0;
        while(i<n1 || j<n2){
            int part1=i<n1?Integer.parseInt(s1[i]):0;
            int part2=j<n2?Integer.parseInt(s2[j]):0;
            if(part1>part2){
                return 1;
            }
            else if (part1<part2){
                return -1;
            }
            i++;
            j++;

        }
      
       return 0;

    }
}