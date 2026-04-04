class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
          int rows=grid.length;
        int cols=grid[0].length;
        boolean leftoright=true;
        int i=0;
        List<Integer>ans=new ArrayList<>();
         boolean taken=true;
        while(i<rows){
           
             if(leftoright){
            for(int j=0;j<cols;j++){
                if(taken){
                    System.out.println(grid[i][j]+" ,");
                    ans.add(grid[i][j]);
                   
                }
                 taken=!taken;

            }
            
             }
           else {
                for(int j=cols-1;j>=0;j--){
                if(taken){
                    System.out.println(grid[i][j]+" ,");
                    ans.add(grid[i][j]);
                    
                }
                taken=!taken;

            }
                
            }
            leftoright=!leftoright;
            i++;
        }
        return ans;
        
    }
}