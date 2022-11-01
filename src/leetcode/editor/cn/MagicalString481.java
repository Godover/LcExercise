/**
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * <p>
 * <p>
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2
 * 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 .....
 * ." 。上面的出现次数正是 s 自身。
 * <p>
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
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
 * 1 <= n <= 10⁵
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 99 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 神奇字符串
 * @id 481
 * @Slug magical-string
 * @date 2022-10-31 10:04:34
 */
public class MagicalString481 {
	public static void main(String[] args) {
		MagicalString481 question = new MagicalString481();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int magicalString(int n) {
			char[] s = new char[n + 2];
			s[0] = 1;
			s[1] = s[2] = 2;
			char c = 2;
			for (int i = 2, j = 3; j < n; ++i) {
				c ^= 3; // 1^3=2, 2^3=1，这样就能在 1 和 2 之间转换
				s[j++] = c;
				if (s[i] == 2) {
					s[j++] = c;
				}
			}
			int ans = 0;
			for (int i = 0; i < n; ++i) ans += 2 - s[i]; // 2-1=1，2-2=0，这样就只统计了 1
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */