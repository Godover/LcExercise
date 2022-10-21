/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1
 * 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 👍 81 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 最大升序子数组和
 * @id 1800
 * @Slug maximum-ascending-subarray-sum
 * @date 2022-10-07 22:23:28
 */
public class MaximumAscendingSubarraySum1800 {
	public static void main(String[] args) {
		MaximumAscendingSubarraySum1800 question = new MaximumAscendingSubarraySum1800();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int maxAscendingSum(int[] nums) {
			// sum 和值  max 最大值
			int sum = nums[0], max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i - 1] >= nums[i]) {
					sum = nums[i];
				} else {
					sum += nums[i];
				}
				max = Math.max(max, sum);
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/07 22:28:10
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.9 MB,击败了93.91% 的Java用户


 */