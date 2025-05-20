class Solution {
    public int maxCoins(int[] a) {
        Arrays.sort(a);
        n=a.length;
        int sum = 0;
        int left = 0, right = n - 1;

        for(int i = 0; i < n / 3; i++){
            sum += a[right - 1];
            left++;
            right -= 2;
        }

        return sum;
    }
}