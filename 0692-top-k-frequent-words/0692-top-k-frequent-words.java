class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>map=new HashMap<>();
        int n=words.length;
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<String>minheap=new PriorityQueue<>((a,b)->{
           int diff=map.get(a)-map.get(b);
           if(diff==0){
            return b.compareTo(a);
           }
           return diff;
        }
        );
        for(String entry:map.keySet()){
            minheap.offer(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        List<String>res=new ArrayList<>();
        while(!minheap.isEmpty()){
            res.add(minheap.poll());
        }
         Collections.reverse(res);
         return res;
    }
}