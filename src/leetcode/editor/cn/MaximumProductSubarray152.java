/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 1756 👎 0
 */


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author ziker
 * @title 乘积最大子数组
 * @id 152
 * @Slug maximum-product-subarray
 * @date 2022-08-19 16:54:42
 */
public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        MaximumProductSubarray152 question = new MaximumProductSubarray152();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{2, -5, -2, -4, 3}));
        // [2, 0, 0, 0, 0]
        // [-10, -5, 0, 0, 0]
        // [20, 10, -2, 0, 0]
        // [-80, -40, 8, -4, 0]
        // [-240, -120, 24, -12, 3]
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // 动态规划 O(1) 空间复杂度  O(N) 时间复杂度
        // 影响最大结果的只有两个值，一个是最大值，一个是最小值，所以只需要记算这两个值即可以,不用计算区间范围的其他值
        //          [2, 0, 0, 0, 0]             2  2    有用
        //          [-10, -5, 0, 0, 0]          -5 -10  有用
        //          [20, 10, -2, 0, 0]          -2 20   有用
        //          [-80, -40, 8, -4, 0]        8  -80  有用
        //          [-240, -120, 24, -12, 3]    24 -240 有用
        //          下面每一个有用的数都是上面结果中的最大值和最小值两个值延伸来的
        //          由此可见，可以只保留上一次的最大值和最小值，压根不需要保留每次的结果
        public int maxProduct(int[] nums) {
            int maxF = nums[0];
            int minF = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int minCur = minF * nums[i];
                int maxCur = maxF * nums[i];
                maxF = Math.max(maxCur, Math.max(minCur, nums[i]));
                minF = Math.min(maxCur, Math.min(minCur, nums[i]));
                // 取任一最大值
                max = Math.max(max, maxF);
            }
            return max;
        }

        // 动态规划 O(N) 空间复杂度  O(N) 时间复杂度
        // 影响最大结果的只有两个值，一个是最大值，一个是最小值，所以只需要记算这两个值即可以,不用计算区间范围的其他值
        //          [2, 0, 0, 0, 0]             2 有用
        //          [-10, -5, 0, 0, 0]          -5 -10 有用
        //          [20, 10, -2, 0, 0]          -2  20 有用
        //          [-80, -40, 8, -4, 0]        8   -80 有用
        //          [-240, -120, 24, -12, 3]    24  -240 有用   下面每一个有用的数都是上面结果中的最大值和最小值两个值延伸来的
        public int maxProduct3(int[] nums) {
            int n = nums.length;
            int[] maxF = new int[n];
            int[] minF = new int[n];
            maxF[0] = minF[0] = nums[0];
            for (int i = 1; i < n; i++) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(minF[i - 1] * nums[i], nums[i]));
                minF[i] = Math.min(maxF[i - 1] * nums[i], Math.min(minF[i - 1] * nums[i], nums[i]));
            }
            int max = Integer.MIN_VALUE;
            for (int v : maxF) {
                max = Math.max(max, v);
            }
            return max;
        }


        // 动态规划|滚动数组 O(N) 空间复杂度  O(NLogN) 时间复杂度
        public int maxProduct2(int[] nums) {
            int n = nums.length, max = Integer.MIN_VALUE;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = nums[i];
                max = Math.max(max, dp[i]);
                // 滚动覆盖新值，因为需要连续区间，所以老旧的数据可以覆盖掉
                for (int j = 0; j < i; j++) {
                    dp[j] = dp[j] * dp[i];
                    // 每一次计算新值时取最大的
                    max = Math.max(max, dp[j]);
                }
                System.out.println(Arrays.toString(dp));
            }
            return max;
        }


        // 动态规划  但是会超时  可以将dp数组优化成滚动数组
        public int maxProduct1(int[] nums) {
            int n = nums.length, max = Integer.MIN_VALUE;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
                max = Math.max(max, nums[i]);
                for (int j = 0; j < i; j++) {
                    dp[i][j] = nums[i] * dp[i - 1][j];
                    max = Math.max(max, dp[i][j]);
                }
                System.out.println(Arrays.toString(dp[i]));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划 O(N) 空间复杂度  O(NLogN) 时间复杂度
> 2022/08/19 17:24:17
解答成功:
	执行耗时:356 ms,击败了5.00% 的Java用户
	内存消耗:41.5 MB,击败了66.38% 的Java用户




动态规划 O(N) 空间复杂度  O(N) 时间复杂度
> 2022/08/19 17:46:45
解答成功:
	执行耗时:1 ms,击败了95.45% 的Java用户
	内存消耗:41.7 MB,击败了35.44% 的Java用户




动态规划 O(1) 空间复杂度  O(N) 时间复杂度
> 2022/08/19 17:59:08
解答成功:
	执行耗时:2 ms,击败了66.62% 的Java用户
	内存消耗:41.4 MB,击败了75.00% 的Java用户


 */