class Solution {
    public int countPrimes(int n) {
    //Sieve Of Erastnaos
     if (n <= 2) return 0;
    boolean isPrime[]=new boolean[n];
    Arrays.fill(isPrime,true);
    isPrime[0]=false;
    isPrime[1]=false;
    for(int i=2;i*i<n;i++){
        if(isPrime[i]==true){
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=false;

            }
        }
    }
    int c=0;
    for(int i=2;i<n;i++) {
        if(isPrime[i]==true) c++;
    }
    return c;
    }
}