import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class SumOfSubArraysMinimum {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = (long) 1e9 + 7;
        long result = 0;
        // Create 2 arrays one for previous smallest and
        // one for next smallest element of same length
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // Fill left and right array with -1
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        // Fill left array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        // Clear stack for Next smallest index
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        //Final calculation
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            result = (result + contribution) % MOD;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int[] test = {3,1,2,4};
        int result = sumSubarrayMins(test);
        System.out.println(result);
    }
}

