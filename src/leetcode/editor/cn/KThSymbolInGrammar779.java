/**
 * 我们构建了一个包含 n 行( 索引从 1 开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * <p>
 * <p>
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 * <p>
 * <p>
 * Related Topics 位运算 递归 数学 👍 202 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 第K个语法符号
 * @id 779
 * @Slug k-th-symbol-in-grammar
 * @date 2022-10-20 10:02:30
 */
public class KThSymbolInGrammar779 {
	public static void main(String[] args) {
		KThSymbolInGrammar779 question = new KThSymbolInGrammar779();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		// 536870912
		// 434991989
		System.out.println(Integer.toBinaryString(3-1));
		System.out.println(Integer.toBinaryString(5-1));
		System.out.println(Integer.toBinaryString(12-1));
		System.out.println(Integer.toBinaryString(309-1));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// 当前行的前半截和上一行一样，后半截是上一行取非得到的
		public int kthGrammar1(int n, int k) {
			// 向上遍历到了第1行，则返回结果
			if (k == 1) return 0;
			// 如果k在当前行的后半截，取出上一行的当前位置值取反，向上递推一行，数量减半，得除2
			if (k > (1 << n - 2)) return 1 ^ kthGrammar(n - 1, k - (1 << n - 2));
				// 如果k在当前行的前半截，直接去上一行找
			else return kthGrammar(n - 1, k); // 如果在“黄色区间”，则与上一行值相同
		}

		// https://blog.csdn.net/u012028275/article/details/112596947
		// 奇偶性计算
		public int kthGrammar(int n, int k) {
			k -= 1;
			k ^= k >> 1;
			k ^= k >> 2;
			k = (k & 0x11111111) * 0x11111111;
			return (k >> 28) & 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */