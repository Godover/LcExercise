/**
 * 给定一个按 非递减顺序 排列的数字数组
 * digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
 * digits = ['1','3','5']，我们可以写数字，如
 * '13', '551', 和 '1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i] 是从 '1' 到 '9' 的数
 * digits 中的所有值都 不同
 * digits 按 非递减顺序 排列
 * 1 <= n <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 数学 字符串 二分查找 动态规划 👍 151 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 最大为 N 的数字组合
 * @id 902
 * @Slug numbers-at-most-n-given-digit-set
 * @date 2022-10-18 10:00:38
 */
public class NumbersAtMostNGivenDigitSet902 {
	public static void main(String[] args) {
		NumbersAtMostNGivenDigitSet902 question = new NumbersAtMostNGivenDigitSet902();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)

	// 第一步：如果n是4位数，先计算digits能组成的1、2、3位数的个数之和，这些数因为位数比4小所以必然小于n，所以每一位都可以取任意值，直接使用Math.pow()这个数学公式计算即可。
	//
	//第二步：使用DP的思路计算digits能组成的4位数中小于n的个数：考虑最高位，这一位如果小于n的最高位，则后面3位可以取任意值，也是使用pow这个函数计算即可。其次，如果最高位取值和n的相同，则问题转化正剩余3位取值小于等于n的末尾3位，于是DP的状态转移方程就出现了。也就是说，我们从末位出发，计算digits中小于等于末尾数字的元素个数，然后根据转移方程逐渐向高位推进.......
	class Solution {
		public int atMostNGivenDigitSet(String[] digits, int n) {
			String t = String.valueOf(n);
			int sum = 0, len = t.length();
			for (int i = 1; i < len; i++) {
				sum += Math.pow(digits.length, i);
			}
			int[] dp = new int[len + 1];
			dp[0] = 1;
			for (int i = 1; i <= len; i++) {
				for (String v : digits) {
					char num = t.charAt(t.length() - i);
					if (v.charAt(0) < num) {
						dp[i] += Math.pow(digits.length, i - 1);
					} else if (v.equals(num + "")) {
						dp[i] += dp[i - 1];
					}
				}
			}
			return dp[len] + sum;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */