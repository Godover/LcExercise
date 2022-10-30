/**
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 * <p>
 * <p>
 * Related Topics 位运算 字符串 回溯 👍 449 👎 0
 */


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ziker
 * @title 字母大小写全排列
 * @id 784
 * @Slug letter-case-permutation
 * @date 2022-10-30 12:22:11
 */
public class LetterCasePermutation784 {
	public static void main(String[] args) {
		LetterCasePermutation784 question = new LetterCasePermutation784();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> letterCasePermutation(String s) {
			return next(new ArrayList<>(), s, new LinkedList<>(), 0);
		}

		public List<String> next(List<String> list, String s, LinkedList<Character> builder, int curIndex) {
			if (curIndex == s.length()) {
				StringBuilder b = new StringBuilder();
				for (Character c : builder) {
					b.append(c);
				}
				list.add(b.toString());
				return list;
			}
			char curChar = s.charAt(curIndex);
			// 自己不变向下一层
			builder.add(curChar);
			next(list, s, builder, curIndex + 1);
			builder.removeLast();
			// 是数字则停止
			if (curChar >= '0' && curChar <= '9') {
				return list;
			}
			// 将自己装换大小写继续向下一层
			curChar += curChar >= 'a' && curChar <= 'z' ? -32 : 32;
			builder.add(curChar);
			next(list, s, builder, curIndex + 1);
			builder.removeLast();
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/30 13:48:33
解答成功:
	执行耗时:7 ms,击败了31.21% 的Java用户
	内存消耗:41.9 MB,击败了77.95% 的Java用户

 */