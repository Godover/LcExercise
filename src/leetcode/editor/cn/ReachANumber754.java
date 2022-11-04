/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * <p>
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * <p>
 * <p>
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * -10⁹ <= target <= 10⁹
 * target != 0
 * <p>
 * <p>
 * Related Topics 数学 二分查找 👍 283 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 到达终点数字
 * @id 754
 * @Slug reach-a-number
 * @date 2022-11-04 13:42:56
 */
public class ReachANumber754 {
	public static void main(String[] args) {
		ReachANumber754 question = new ReachANumber754();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int reachNumber(int target) {
			target = Math.abs(target);
			int k = 0;
			int sum = 0;
			// sum-target % 2 != 0 这个条件是，如果和值和目标值之间差值为奇数的情况下，则不能通过一次翻转数值达到要求，因为一次翻转的值总和偶数
			while (sum < target || (sum - target) % 2 != 0) {
				sum += ++k;
			}
			return k;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/11/04 14:06:56
解答成功:
	执行耗时:1 ms,击败了81.23% 的Java用户
	内存消耗:38.2 MB,击败了67.87% 的Java用户


 */