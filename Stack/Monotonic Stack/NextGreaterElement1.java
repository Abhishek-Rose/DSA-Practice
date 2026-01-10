import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement1 {
    public static int[] nextGreater(int[] nums) {    // Right To Left Traversal
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {    // write only stack.peek() in case of element pushing
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];    // write nums[stack.peek()] in case for assigning peek element into result[i]
            stack.push(i);                                            // stack.push(nums[i]) in case for element
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 9, 23, 5, 8, 8, 9};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
}
