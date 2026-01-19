class Solution:
    def lexicalOrder(self, n: int):
        result = []
        current = 1

        for _ in range(n):
            result.append(current)

            if current * 10 <= n:
                # Go to the next depth (e.g., 1 → 10)
                current *= 10
            else:
                # Move to the next valid number
                while current % 10 == 9 or current + 1 > n:
                    current //= 10
                current += 1

        return result
