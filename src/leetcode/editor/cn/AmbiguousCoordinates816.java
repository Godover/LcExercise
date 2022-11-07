/**
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * <p>
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表
 * 示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * <p>
 * <p>
 * <p>
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)
 * "]
 * <p>
 * <p>
 * <p>
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 字符串 回溯 👍 79 👎 0
 */


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziker
 * @title 模糊坐标
 * @id 816
 * @Slug ambiguous-coordinates
 * @date 2022-11-07 10:03:01
 */
public class AmbiguousCoordinates816 {
	public static void main(String[] args) {
		AmbiguousCoordinates816 question = new AmbiguousCoordinates816();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.ambiguousCoordinates("(0123)"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<String> ambiguousCoordinates(String s) {
			s = s.substring(1, s.length() - 1);
			List<String> list = new ArrayList<>();
			for (int i = 1; i < s.length(); i++) {
				// 左半部分可能有的组合
				List<String> left = singleList(s.substring(0, i));
				if (left.isEmpty()) {
					continue;
				}
				// 右半部分可能有的组合
				List<String> right = singleList(s.substring(i));
				if (right.isEmpty()) {
					continue;
				}
				// 对两部分数取笛卡尔积
				for (String lSingle : left) {
					for (String rSingle : right) {
						list.add("(" + lSingle + ", " + rSingle + ")");
					}
				}
			}
			return list;
		}


		public List<String> singleList(String subStr) {
			ArrayList<String> list = new ArrayList<>();
			for (int i = 1; i <= subStr.length(); i++) {
				String left = subStr.substring(0, i);
				// 去除左边长度大于1且0开头的数，保留了 0.1 这种小数
				if (left.length() != 1 && left.charAt(0) == '0') {
					continue;
				}
				String right = subStr.substring(i);
				// 去除0结尾的数
				if (right.endsWith("0")) {
					continue;
				}
				list.add(left + (right.length() != 0 ? "." : "") + right);
			}
			return list;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/07 11:10:03
解答成功:
	执行耗时:11 ms,击败了52.48% 的Java用户
	内存消耗:42.6 MB,击败了26.95% 的Java用户

 */