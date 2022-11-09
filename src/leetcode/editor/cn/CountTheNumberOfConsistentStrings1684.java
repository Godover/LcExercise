/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串
 * 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 10⁴
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * <p>
 * <p>
 * Related Topics 位运算 数组 哈希表 字符串 👍 105 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 统计一致字符串的数目
 * @id 1684
 * @Slug count-the-number-of-consistent-strings
 * @date 2022-11-09 10:39:29
 */
public class CountTheNumberOfConsistentStrings1684 {
	public static void main(String[] args) {
		CountTheNumberOfConsistentStrings1684 question = new CountTheNumberOfConsistentStrings1684();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int countConsistentStrings(String allowed, String[] words) {
			int[] chars = new int[128];
			for (char c : allowed.toCharArray()) {
				chars[c] = 1;
			}
			int count = words.length;
			for (String word : words) {
				for (char c : word.toCharArray()) {
					if (chars[c] == 0) {
						count--;
						break;
					}
				}
			}
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/09 10:41:45
解答成功:
	执行耗时:5 ms,击败了97.38% 的Java用户
	内存消耗:42.5 MB,击败了25.60% 的Java用户

 */