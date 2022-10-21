/**
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围
 * 为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 * <p>
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 * <p>
 * 在对 nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 10⁴
 * 0 <= k <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 169 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 最小差值 I
 * @id 908
 * @Slug smallest-range-i
 * @date 2022-10-21 11:43:41
 */
public class SmallestRangeI908 {
	public static void main(String[] args) {
		SmallestRangeI908 question = new SmallestRangeI908();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int smallestRangeI(int[] nums, int k) {
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for (int num : nums) {
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			// 如果max-min-2k小于0了就取0
			return Math.max((max - min) - 2 * k, 0);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/21 11:49:15
解答成功:
	执行耗时:3 ms,击败了78.75% 的Java用户
	内存消耗:42.3 MB,击败了9.88% 的Java用户

 */