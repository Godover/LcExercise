/**
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1
 * 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁵ <= nums[i] <= 10⁵
 * 1 <= k <= 10⁹
 * <p>
 * <p>
 * Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 483 👎 0
 */


package leetcode.editor.cn;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author ziker
 * @title 和至少为 K 的最短子数组
 * @id 862
 * @Slug shortest-subarray-with-sum-at-least-k
 * @date 2022-10-26 10:04:33
 */
public class ShortestSubarrayWithSumAtLeastK862 {
	public static void main(String[] args) {
		ShortestSubarrayWithSumAtLeastK862 question = new ShortestSubarrayWithSumAtLeastK862();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.shortestSubarray(new int[]{2, -1, 2}, 3));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int shortestSubarray(int[] nums, int k) {
			long[] sum = new long[nums.length + 1];
			// 前缀和
			for (int i = 0; i < nums.length; i++) {
				sum[i + 1] = sum[i] + nums[i];
			}
			//利用双端队列和前缀和缩短时间复杂度来完成比较
			//进入deque里的值都相当于i, j相当于j,判断(i, j)之间是否满足>=k
			LinkedList<Integer> queue = new LinkedList<>();
			int minLen = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length + 1; i++) {
				//01.一旦i到j之间的元素和是负数或0时,相当于是累赘,不利于后序累加,应该舍弃此i
				while (!queue.isEmpty() && sum[i] <= sum[queue.peekLast()]) {
					queue.pollLast();
				}
				//02.一旦i到j之间的元素和>=k了,后续的j也只会让长度增加,比较此时长度就可以舍弃此i
				while (!queue.isEmpty() && sum[i] - sum[queue.peekFirst()] >= k) {
					Integer firstIndex = queue.pollFirst();
					minLen = Math.min(minLen, i - firstIndex);
				}
				queue.addLast(i);
			}
			return minLen == Integer.MAX_VALUE ? -1 : minLen;
		}


		// 超时
		public int shortestSubarray1(int[] nums, int k) {
			int[] sum = new int[nums.length];
			// 0：和值 1:起始坐标
			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
//			Queue<int[]> queue = new ArrayDeque<>();
			int minLen = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				queue.add(new int[]{0, i});
				// 大顶堆最大的一个元素
				int[] first = queue.peek();
				// 遍历整个队列
				Iterator<int[]> iterator = queue.iterator();
				while (iterator.hasNext()) {
					int[] v = iterator.next();
					// 维护每个元素值
					v[0] += nums[i];
					// 如果元素和值大于 k 了,维护最小值
					if (v[0] >= k) {
						minLen = Math.min(i - v[1] + 1, minLen);
					}
					// 如果大于k或者小于0或者(坐标小于最大的元素值) 移除当前元素,少维护几个元素
					if (v[0] >= k || v[0] <= 0 || (v[0] < first[0])) {
						iterator.remove();
					}

				}
			}
			return minLen == Integer.MAX_VALUE ? -1 : minLen;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/26 11:59:19
解答成功:
	执行耗时:31 ms,击败了56.89% 的Java用户
	内存消耗:50.8 MB,击败了72.73% 的Java用户


 */