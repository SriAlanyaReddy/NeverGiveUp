class Solution {
    public int[] closestPrimes(int left, int right) {
    //sieve of erasthanos
    boolean sieve[]=new boolean[right+1];
    Arrays.fill(sieve,true);
    sieve[0]=sieve[1]=false;
    for(int prime=2;prime*prime<=right;prime++){
        if(sieve[prime]){
            for(int multiples=2;prime*multiples<=right;multiples++){
                int product=prime*multiples;
                sieve[product]=false;
            }
        }
    } 
   int res[]=new int[]{-1,-1};
    List<Integer> primes = new ArrayList<>();
   int min=Integer.MAX_VALUE;
   for(int i=left;i<=right;i++){
    if(sieve[i]==true){
        primes.add(i);

    }
   }
   if(primes.size()<2){
    return res;
   }
   for(int i=1;i<primes.size();i++){
    int diff=primes.get(i)-primes.get(i-1);
    if(diff<min){
        min=diff;
        res[0]=primes.get(i-1);
        res[1]=primes.get(i);
    }
   }
   return res;
    }
}