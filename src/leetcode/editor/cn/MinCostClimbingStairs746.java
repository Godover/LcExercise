/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 990 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 使用最小花费爬楼梯
 * @id 746
 * @Slug min-cost-climbing-stairs
 * @date 2022-08-18 19:20:06
 */
public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        MinCostClimbingStairs746 question = new MinCostClimbingStairs746();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] dp = new int[len];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < len; i++) {
                // 走到当前位置的代价为前面两步中最小代价+当前位置的代价
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
            return Math.min(dp[len - 1], dp[len - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划
> 2022/08/18 19:55:08
解答成功:
	执行耗时:1 ms,击败了5.68% 的Java用户
	内存消耗:41.7 MB,击败了5.15% 的Java用户

> 2022/08/18 19:58:46
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41.6 MB,击败了5.15% 的Java用户


 */