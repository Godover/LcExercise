/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * <p>
 * <p>
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁶
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
 * <p>
 * <p>
 * Related Topics 数组 👍 146 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 分割数组
 * @id 915
 * @Slug partition-array-into-disjoint-intervals
 * @date 2022-10-24 11:01:07
 */
public class PartitionArrayIntoDisjointIntervals915 {
	public static void main(String[] args) {
		PartitionArrayIntoDisjointIntervals915 question = new PartitionArrayIntoDisjointIntervals915();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int partitionDisjoint(int[] nums) {
			// 左数组最大值
			int leftMax = nums[0];
			// 当前最大值
			int max = nums[0];
			int index = 0;
			for (int i = 0; i < nums.length; i++) {
				// 维护当前遍历的最大值
				max = Math.max(max, nums[i]);
				// 如果 左数组最大值 大于 当前遍历值
				if (leftMax > nums[i]) {
					// 将 左数组指针 移动到 当前位置
					index = i;
					// 更新 左数组最大值 为 当前维护的最大值
					leftMax = max;
				}
			}
			// 返回的是序号
			return index + 1;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*


> 2022/10/24 11:27:39
解答成功:
	执行耗时:3 ms,击败了92.81% 的Java用户
	内存消耗:50.2 MB,击败了91.47% 的Java用户

 */