class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>>g=new HashMap<>();
        int n=equations.size();
      for(int i=0;i<n;i++){
        String  st=equations.get(i).get(0);
        String end=equations.get(i).get(1);
        double val=values[i];
        g.putIfAbsent(st,new HashMap<>());
        g.putIfAbsent(end,new HashMap<>());

        g.get(st).put(end,val);
        g.get(end).put(st,1/val);


      }  
      double res[]=new double[queries.size()];
      int i=0;
      for(List<String> query:queries){
        String src=query.get(0);
        String dest=query.get(1);
       if(!g.containsKey(src) || !g.containsKey(dest)){
        res[i]=-1;
       }
       else if(src.equals(dest)){
        res[i]=1;
       }
       else{
        HashSet<String>visited=new HashSet<>();
        res[i]=dfs(visited,src,dest,1,g);
       }
       i++;


      }
      return res;
    }
    public double dfs(HashSet<String> visited,String source,String target,double product,Map<String,Map<String,Double>>g){
        visited.add(source);
        if(source.equals(target)){
            return product;


        }
        for(Map.Entry<String,Double>adj:g.get(source).entrySet()){
            if(!visited.contains(adj.getKey())){
                double result=dfs(visited,adj.getKey(),target,product*adj.getValue(),g);
                if(result!=-1.0){
                    return result;
                }
            }
        }
        return -1.0;
    }
}