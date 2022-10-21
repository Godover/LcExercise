/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * <p>
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * <p>
 * <p>
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一
 * 棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * <p>
 * <p>
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= fruits.length <= 10⁵
 * 0 <= fruits[i] < fruits.length
 * <p>
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 310 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 水果成篮
 * @id 904
 * @Slug fruit-into-baskets
 * @date 2022-10-17 10:21:58
 */
public class FruitIntoBaskets904 {
	public static void main(String[] args) {
		FruitIntoBaskets904 question = new FruitIntoBaskets904();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int totalFruit(int[] fruits) {
			// 计数值，统计的是 12112 这样子一串只有两个数字的计数值
			int count = 1;
			// 计数最大值
			int max = 1;
			// 上个不同数字的起始位置
			int preNumStartIndex = 0;
			int[] map = new int[]{fruits[0], fruits[0]};
			for (int i = 1; i < fruits.length; i++) {
				// 如果当前数字和篮子的两个数字都不同，则进行重新放置篮子，并重新计数
				if (map[0] != fruits[i] && map[1] != fruits[i]) {
					map[0] = fruits[i];
					map[1] = fruits[i - 1]; // == fruits[preNumStartIndex]
					// 将计数设置为当前位置到上一个数字的起始位置之间距离
					count = i - preNumStartIndex;
				}
				// 如果数字变更，重新计数这个位置起始值
				if (fruits[i] != fruits[i - 1]) {
					preNumStartIndex = i;
				}
				// 每遍历一次，++count，取最大值
				max = Math.max(max, ++count);
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/17 11:39:10
解答成功:
	执行耗时:7 ms,击败了73.20% 的Java用户
	内存消耗:51.1 MB,击败了17.33% 的Java用户

> 2022/10/17 11:49:33
解答成功:
	执行耗时:6 ms,击败了85.90% 的Java用户
	内存消耗:51 MB,击败了20.96% 的Java用户

 */