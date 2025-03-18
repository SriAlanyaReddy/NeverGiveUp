class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int a[]=new int[n+1];
        for(int[] booking:bookings){
            a[booking[0]]+=booking[2];
            if(booking[1]+1<=n)
            a[booking[1]+1]-=booking[2];
        }
        for(int i=1;i<=n;i++){
            a[i]+=a[i-1];
        }
        return Arrays.copyOfRange(a,1,n+1);

    }
}