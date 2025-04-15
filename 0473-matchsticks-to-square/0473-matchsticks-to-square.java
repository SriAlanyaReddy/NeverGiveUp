import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks) sum += stick;

        if (sum % 4 != 0) return false;

        int target = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks); // Sorting in descending order helps to prune faster

        int[] sides = new int[4]; // To hold the length of each side

        return dfs(matchsticks, 0, sides, target);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if (dfs(matchsticks, index + 1, sides, target)) return true;
                sides[i] -= matchsticks[index]; // backtrack
            }
        }

        return false;
    }

    private void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
