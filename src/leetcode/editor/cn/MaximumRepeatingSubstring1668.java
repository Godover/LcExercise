/**
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为
 * k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为
 * 0 。
 * <p>
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和 word 都只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 字符串 字符串匹配 👍 61 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 最大重复子字符串
 * @id 1668
 * @Slug maximum-repeating-substring
 * @date 2022-11-03 10:16:05
 */
public class MaximumRepeatingSubstring1668 {
	public static void main(String[] args) {
		MaximumRepeatingSubstring1668 question = new MaximumRepeatingSubstring1668();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// 模拟加动态规划
		public int maxRepeating(String sequence, String word) {
			int wLen = word.length();
			int sLen = sequence.length();
			// 边界条件
			if (wLen >= sLen) {
				return word.equals(sequence) ? 1 : 0;
			}
			// 当前位置的连续值
			int[] dp = new int[sLen];
			int max = 0;
			for (int i = 0; i <= sLen - wLen; i++) {
				// 子串相等
				if (sequence.substring(i, i + wLen).equals(word)) {
					// 当前位置的连续值等于 上一个距离自己为子串长度的位置的值加1
					dp[i] = (i >= wLen ? dp[i - wLen] : 0) + 1;
					// 维护最大值
					max = Math.max(max, dp[i]);
				}
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/03 14:50:54
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:40.1 MB,击败了10.93% 的Java用户

 */