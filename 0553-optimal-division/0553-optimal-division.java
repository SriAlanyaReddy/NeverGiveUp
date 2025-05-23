class Solution {
    public String optimalDivision(int[] a) {
        int n=a.length;
        if(a.length==1){
            return a[0]+"";
        }
        if(a.length==2){
            return a[0]+"/"+a[1];
        }
        StringBuilder sb=new StringBuilder(a[0]+"/("+a[1]);
        for(int i=2;i<n;i++){
            sb.append("/"+a[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}