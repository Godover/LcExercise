/**
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都 不同
 * <p>
 * <p>
 * Related Topics 栈 贪心 数组 排序 单调栈 👍 274 👎 0
 */


package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author ziker
 * @title 最多能完成排序的块
 * @id 769
 * @Slug max-chunks-to-make-sorted
 * @date 2022-10-13 10:21:55
 */
public class MaxChunksToMakeSorted769 {
	public static void main(String[] args) {
		MaxChunksToMakeSorted769 question = new MaxChunksToMakeSorted769();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxChunksToSorted(int[] arr) {
			// 重点是将左侧按照最大值分块   取分块的驼峰最大值数量
			Stack<Integer> maxStack = new Stack<>();
			for (int num : arr) {
				// 栈空或者前面的最大值比当前数小，直接入栈
				if (maxStack.isEmpty() || num > maxStack.peek()) {
					maxStack.push(num);
				} else {
					// 取出上一个最大值
					Integer max = maxStack.pop();
					// 将最大值到比当前数小的最大值列表清空
					while (!maxStack.isEmpty() && num < maxStack.peek()) {
						maxStack.pop();
					}
					maxStack.push(max);
				}
			}
			return maxStack.size();
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/13 13:57:02
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.7 MB,击败了69.54% 的Java用户


 */