/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * <p>
 * <p>
 * Related Topics 栈 递归 字符串 👍 150 👎 0
 */


package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author ziker
 * @title 解析布尔表达式
 * @id 1106
 * @Slug parsing-a-boolean-expression
 * @date 2022-11-05 19:35:58
 */
public class ParsingABooleanExpression1106 {
	public static void main(String[] args) {
		ParsingABooleanExpression1106 question = new ParsingABooleanExpression1106();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean parseBoolExpr(String expression) {
			Stack<Character> stack = new Stack<>();
			for (char c : expression.toCharArray()) {
				if (c == ')') {
					Character pop;
					boolean hasZero = false;
					boolean hasOne = false;
					// 取出括号中的所有值，标记出现状态
					while ((pop = stack.pop()) != '(') {
						hasZero |= pop == 'f';
						hasOne |= pop == 't';
					}
					// 取出括号前面的逻辑运算符
					Character peek = stack.pop();
					stack.push(switch (peek) {
						case '&' -> hasZero ? 'f' : 't';
						case '|' -> hasOne ? 't' : 'f';
						case '!' -> hasOne ? 'f' : 't';
						default -> peek;
					});
				} else {
					stack.push(c);
				}
			}
			return stack.peek() != 'f';
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/05 19:45:08
解答成功:
	执行耗时:15 ms,击败了22.45% 的Java用户
	内存消耗:41.2 MB,击败了80.27% 的Java用户


 */