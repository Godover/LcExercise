/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 19
 * <p>
 * <p>
 * Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1903 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 不同的二叉搜索树
 * @id 96
 * @Slug unique-binary-search-trees
 * @date 2022-08-19 18:53:29
 */
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        UniqueBinarySearchTrees96 question = new UniqueBinarySearchTrees96();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                // 左子树 或者 右子树  任一树为空的情况
                dp[i] = dp[i - 1] * 2;
                for (int j = 1; j < i; j++) {
                    // 左子树各种可能数 * 右子树各种可能数
                    dp[i] += dp[j - 1] * dp[i - j - 1];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

01:07:00

> 2022/08/19 20:01:46
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.5 MB,击败了14.83% 的Java用户

 */