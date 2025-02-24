class Solution {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer>minheap=new PriorityQueue<>();
        int n=a.length;
        for(int i=0;i<k;i++){
            minheap.offer(a[i]);
            
        }
        for(int i=k;i<n;i++){
            int val=a[i];
            if(a[i]>minheap.peek()){
                minheap.poll();
                minheap.offer(val);
            }
        }
        return minheap.peek();
    }
}