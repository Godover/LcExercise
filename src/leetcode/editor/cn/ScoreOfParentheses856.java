/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * (()(()))
 * (1(1))
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 365 👎 0
 */


package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author ziker
 * @title 括号的分数
 * @id 856
 * @Slug score-of-parentheses
 * @date 2022-10-09 10:16:49
 */
public class ScoreOfParentheses856 {
	public static void main(String[] args) {
		ScoreOfParentheses856 question = new ScoreOfParentheses856();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int scoreOfParentheses(String s) {
			Stack<Integer> stack = new Stack<>();
			for (char c : s.toCharArray()) {
				// 左括号入栈，-1做左括号标记
				if (c == '(') {
					stack.push(-1);
					continue;
				}
                // 处理右括号情况
				Integer left;
				int single = 0;
                // 取出到上一个左括号之间的所有数字，求和
				while ((left = stack.pop()) != -1) {
					single += left;
				}
                // 如果和为0说明是单组括号:取1,如果和不为0,说明是 (A) 情况,对和值 *2
				stack.push(single == 0 ? 1 : single * 2);
			}
			// 求和栈中的所有数字
			return stack.stream().reduce(Integer::sum).orElse(0);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/09 10:33:41
解答成功:
	执行耗时:1 ms,击败了45.62% 的Java用户
	内存消耗:39.5 MB,击败了35.06% 的Java用户

 */