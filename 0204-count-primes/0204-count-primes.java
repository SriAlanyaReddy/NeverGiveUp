class Solution {
    public int countPrimes(int n) {
    //Sieve Of Erastnaos
     if (n <= 2) return 0;
   int isPrime[]=new int[n];
    Arrays.fill(isPrime,1);
    
    for(int i=2;i*i<n;i++){
        if(isPrime[i]==1){
            for(int j=i*i;j<n;j+=i){
                isPrime[j]=0;

            }
        }
    }
    int c=0;
    for(int i=2;i<n;i++) {
        if(isPrime[i]==1) c++;
    }
    return c;
    }
}