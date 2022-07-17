/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] productExceptSelf = productExceptSelf(nums);
        for (int n : productExceptSelf) {
            System.out.println(n);
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int[] outputArray = new int[nums.length];
        outputArray[0] = pre;
        for (int i = 1; i < nums.length; i++) {
            outputArray[i] = outputArray[i - 1] * nums[i - 1];
        }
        int post = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            outputArray[i] = outputArray[i] * post;
            post = post * nums[i];
        }
        return outputArray;
    }
}