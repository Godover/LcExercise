/**
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 213 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 第 N 个泰波那契数
 * @id 1137
 * @Slug n-th-tribonacci-number
 * @date 2022-08-19 12:29:32
 */
public class NThTribonacciNumber1137 {
    public static void main(String[] args) {
        NThTribonacciNumber1137 question = new NThTribonacciNumber1137();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            int[] dp = new int[38];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
动态规划
> 2022/08/19 12:32:21
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.4 MB,击败了34.99% 的Java用户

 */