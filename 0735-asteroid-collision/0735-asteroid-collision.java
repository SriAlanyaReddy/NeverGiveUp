class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack will store the asteroids that are still moving without destruction (final survivors)
        Stack<Integer> stack = new Stack<>();

        // Iterate through each asteroid one by one
        for (int a : asteroids) {

            // If the asteroid is moving to the right (positive direction), no collision can happen immediately
            // because collisions only happen when left-moving asteroid meets a right-moving asteroid.
            if (a > 0) {
                stack.push(a);   // So directly push it into the stack
            } 
            else {
                // Now a negative asteroid coming (moving left)
                // This can collide only with last asteroid in stack if it is moving right (positive)

                // Keep checking for collisions while:
                // stack is NOT empty AND
                // top asteroid in stack is moving RIGHT AND
                // its magnitude is smaller than incoming asteroid (so it gets destroyed)
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();   // Right-moving smaller asteroid gets destroyed
                }

                // After popping smaller ones:
                // If stack is EMPTY → nothing to collide with OR
                // If top asteroid is also moving LEFT (negative) → no collision (both go left)
                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);  // Therefore push the current asteroid (it survives)
                }

                // If same magnitude asteroid exists on top in stack → both destroy each other
                else if (stack.peek() == -a) {
                    stack.pop();   // Destroy the asteroid in stack
                    // Do NOT push 'a' because both are destroyed
                }

                // If stack.peek() > -a, that case (smaller negative) is already handled by while loop
                // meaning current asteroid 'a' is destroyed, so nothing else to do.
            }
        }

        // Convert stack to array — final state of surviving asteroids
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        // Pop from stack to store in result (reverse order)
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }
}
