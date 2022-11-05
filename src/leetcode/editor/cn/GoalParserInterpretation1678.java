/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器
 * 会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串
 * 。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 * <p>
 * <p>
 * Related Topics 字符串 👍 41 👎 0
 */


package leetcode.editor.cn;

/**
 * @title 设计 Goal 解析器
 * @id 1678
 * @Slug goal-parser-interpretation
 * @author ziker
 * @date 2022-11-06 01:17:07
 */
public class GoalParserInterpretation1678 {
	public static void main(String[] args) {
		GoalParserInterpretation1678 question = new GoalParserInterpretation1678();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String interpret1(String command) {
			return command.replace("()", "o").replace("(al)", "al");
		}

		public String interpret(String command) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'G') {
					res.append("G");
				} else if (command.charAt(i) == '(') {
					if (command.charAt(i + 1) == ')') {
						res.append("o");
					} else {
						res.append("al");
					}
				}
			}
			return res.toString();
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/06 01:18:06
解答成功:
	执行耗时:1 ms,击败了52.78% 的Java用户
	内存消耗:40 MB,击败了6.21% 的Java用户


*/