/**
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来
 * 描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length <= 10⁵
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 排序 👍 233 👎 0
 */


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ziker
 * @title 优势洗牌
 * @id 870
 * @Slug advantage-shuffle
 * @date 2022-10-08 10:05:17
 */
public class AdvantageShuffle870 {
	public static void main(String[] args) {
		AdvantageShuffle870 question = new AdvantageShuffle870();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] advantageCount(int[] nums1, int[] nums2) {
			int[] nums = new int[nums1.length];
			List<Integer> list = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
			for (int i = 0; i < nums2.length; i++) {
				nums[i] = getFirstNum(list, nums2[i]);
			}
			return nums;
		}

		public int getFirstNum(List<Integer> nums, int num) {
			// 最后一个大数都不大于当前数，取最小的一个值赋值到当前位置
			if (num >= nums.get(nums.size() - 1)) {
				return nums.remove(0);
			}
			// 二分查找第一个大于当前数的位置
			int left = 0, right = nums.size() - 1;
			while (left < right) {
				int mid = left + ((right - left) >> 1);
				if (nums.get(mid) <= num) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			return nums.remove(left);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/08 11:06:07
解答成功:
	执行耗时:279 ms,击败了5.05% 的Java用户
	内存消耗:60.7 MB,击败了15.54% 的Java用户

 */