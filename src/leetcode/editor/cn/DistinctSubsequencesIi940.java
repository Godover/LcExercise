/**
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * <p>
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * <p>
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 189 👎 0
 */


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author ziker
 * @title 不同的子序列 II
 * @id 940
 * @Slug distinct-subsequences-ii
 * @date 2022-10-14 10:01:10
 */
public class DistinctSubsequencesIi940 {
	public static void main(String[] args) {
		DistinctSubsequencesIi940 question = new DistinctSubsequencesIi940();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.distinctSubseqII("a"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		int MOD = (int) 1e9 + 7;

		public int distinctSubseqII(String s) {
			int n = s.length(), ans = 0;
			int[] f = new int[26];
			for (int i = 0; i < n; i++) {
				int c = s.charAt(i) - 'a';
				// 当前字符上一次的总次数
				int prev = f[c];
				f[c] = (ans + 1) % MOD;
				ans = (ans + f[c]) % MOD;
				ans = (ans - prev + MOD) % MOD;
			}
			return ans;
		}

		/**
		 * 这种办法通过维护总数更新出上面的办法
		 */
		public int distinctSubseqII1(String s) {
			long[] dp = new long[26];
			for (int i = 0; i < s.length(); i++) {
                // 如果这个字符结尾前面已经存在了，则只会新加一个，即加上自己的整个序列，用当前这个数替换前面这个数，就达到去重的效果
                // 将当前方法 优化到 维持 ans 数量，则就是上面的代码
				dp[s.charAt(i) - 'a'] = (Arrays.stream(dp).sum() + 1) % 1000000007;
			}
			return (int) (Arrays.stream(dp).sum() % 1000000007);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */