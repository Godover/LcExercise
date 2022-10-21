/**
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 * <p>
 * <p>
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4
 * ] 和 nums2 =[5,6,7,8] 。
 * <p>
 * <p>
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * <p>
 * 数组 arr 严格递增 且 arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 * <p>
 * 注意：
 * <p>
 * <p>
 * 用例保证可以实现操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 2 <= nums1.length <= 10⁵
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 2 * 10⁵
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 298 👎 0
 */


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author ziker
 * @title 使序列递增的最小交换次数
 * @id 801
 * @Slug minimum-swaps-to-make-sequences-increasing
 * @date 2022-10-10 10:11:14
 */
public class MinimumSwapsToMakeSequencesIncreasing801 {
	public static void main(String[] args) {
		MinimumSwapsToMakeSequencesIncreasing801 question = new MinimumSwapsToMakeSequencesIncreasing801();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.minSwap(new int[]{
				3, 3, 8, 9, 10
		}, new int[]{
				1, 7, 4, 6, 8
		}));

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int minSwap(int[] nums1, int[] nums2) {
			// 0 定义为本次不交换
			// 1 定义为本次交换
			int n = nums1.length;
			int[][] dp = new int[n][2];
			// 将除第0次后面的成本都增大，因为不交换可能会不符合要求，所以每次应舍弃不交换的机会，根据前面的结果判断是否交换
			for (int i = 1; i < n; i++) {
				Arrays.fill(dp[i], n + 1);
			}
			dp[0][0] = 0; // 本次不交换
			dp[0][1] = 1; // 本次交换
			for (int i = 1; i < n; i++) {
				// 符合条件,    1 3   2 4,两个都是顺序的
				if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
					// 取上一次不交换的次数
					dp[i][0] = dp[i - 1][0];
					// 这里要取上一次交换的结果加+1，两个数组，如果只有一个交换，一个不交换，就会交叉，所以要不都交换，要不都不交换
					dp[i][1] = dp[i - 1][1] + 1;
				}
				// 交叉大于  2 5   3 4,交换任意一个数都符合条件
				if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
					dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
					dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
				}
			}
			return Math.min(dp[n - 1][0], dp[n - 1][1]);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/10 16:56:33
解答成功:
	执行耗时:16 ms,击败了15.97% 的Java用户
	内存消耗:52.5 MB,击败了61.22% 的Java用户

 */