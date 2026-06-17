class Solution {
    public int sumFourDivisors(int[] a) {

        int ans = 0;

        for (int num : a) {

            int c = 2;          // 1 and num
            int s = 1 + num;

            for (int d = 2; d * d <= num; d++) {

                if (num % d == 0) {

                    c++;
                    s += d;

                    if (d != num / d) {
                        c++;
                        s += num / d;
                    }

                    if (c > 4) break;
                }
            }

            if (c == 4)
                ans += s;
        }

        return ans;
    }
}