/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= word1.length, word2.length <= 10³
 * 1 <= word1[i].length, word2[i].length <= 10³
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³
 * word1[i] 和 word2[i] 由小写字母组成
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 42 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 检查两个字符串数组是否相等
 * @id 1662
 * @Slug check-if-two-string-arrays-are-equivalent
 * @date 2022-11-01 09:59:09
 */
public class CheckIfTwoStringArraysAreEquivalent1662 {
	public static void main(String[] args) {
		CheckIfTwoStringArraysAreEquivalent1662 question = new CheckIfTwoStringArraysAreEquivalent1662();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
			int p1 = 0, p2 = 0, i = 0, j = 0;
			while (p1 < word1.length && p2 < word2.length) {
				if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
					return false;
				}
				i++;
				j++;
				if (i == word1[p1].length()) {
					p1++;
					i = 0;
				}
				if (j == word2[p2].length()) {
					p2++;
					j = 0;
				}
			}
			return p1 == word1.length && p2 == word2.length;
		}

		public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
			StringBuilder b1 = new StringBuilder();
			StringBuilder b2 = new StringBuilder();
			for (String s : word1) {
				b1.append(s);
			}
			for (String s : word2) {
				b2.append(s);
			}
			return b1.toString().equals(b2.toString());
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/01 10:04:49
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.7 MB,击败了17.89% 的Java用户

 */