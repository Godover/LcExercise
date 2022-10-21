/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * <p>
 * <p>
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 100
 * <p>
 * <p>
 * Related Topics 数组 动态规划 模拟 👍 70 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 获取生成数组中的最大值
 * @id 1646
 * @Slug get-maximum-in-generated-array
 * @date 2022-08-19 12:35:11
 */
public class GetMaximumInGeneratedArray1646 {
    public static void main(String[] args) {
        GetMaximumInGeneratedArray1646 question = new GetMaximumInGeneratedArray1646();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGenerated(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaximumGenerated(int n) {
            if (n < 2) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) dp[i] = dp[i / 2];
                else dp[i] = dp[i / 2 + 1] + dp[i / 2];
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划
> 2022/08/19 12:52:31
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.4 MB,击败了41.64% 的Java用户


 */