/**
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 计数 👍 55 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 仅执行一次字符串交换能否使两个字符串相等
 * @id 1790
 * @Slug check-if-one-string-swap-can-make-strings-equal
 * @date 2022-10-11 10:00:41
 */
public class CheckIfOneStringSwapCanMakeStringsEqual1790 {
	public static void main(String[] args) {
		CheckIfOneStringSwapCanMakeStringsEqual1790 question = new CheckIfOneStringSwapCanMakeStringsEqual1790();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean areAlmostEqual(String s1, String s2) {
			int count = 0, c1 = 0, c2 = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s2.charAt(i) != s2.charAt(i)) {
					switch (++count) {
						case 1:
							c1 = s1.charAt(i);
							c2 = s2.charAt(i);
							break;
						case 2:
							if (c1 != s2.charAt(i) || c2 != s1.charAt(i)) {
								return false;
							}
							break;
						default:
							return false;
					}
				}
			}
			return count != 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/11 10:10:42
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.4 MB,击败了82.21% 的Java用户

 */