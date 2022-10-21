/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * <p>
 * 给定 n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 30
 * <p>
 * <p>
 * Related Topics 递归 记忆化搜索 数学 动态规划 👍 519 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 斐波那契数
 * @id 509
 * @Slug fibonacci-number
 * @date 2022-08-18 19:14:08
 */
public class FibonacciNumber509 {
    public static void main(String[] args) {
        FibonacciNumber509 question = new FibonacciNumber509();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int[] f = new int[n + 1];
            f[0] = 0;
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划
> 2022/08/18 19:17:30
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.5 MB,击败了22.29% 的Java用户

 */