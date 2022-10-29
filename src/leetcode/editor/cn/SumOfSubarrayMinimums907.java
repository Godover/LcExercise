/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 3 * 10⁴
 * 1 <= arr[i] <= 3 * 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 栈 数组 动态规划 单调栈 👍 525 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 子数组的最小值之和
 * @id 907
 * @Slug sum-of-subarray-minimums
 * @date 2022-10-28 15:58:17
 */
public class SumOfSubarrayMinimums907 {
	public static void main(String[] args) {
		SumOfSubarrayMinimums907 question = new SumOfSubarrayMinimums907();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		System.out.println(solution.sumSubarrayMins(new int[]{11, 81, 94, 43, 3, 3, 5, 3, 64, 3, 5, 2, 4, 2, 1, 1, 12}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int sumSubarrayMins(int[] arr) {
			int len = arr.length;
			int[] min = new int[len];
			int sum = 0;
			for (int i = 0; i < len; i++) {
				min[i] = arr[i];
				sum += min[i];
				for (int j = i + 1; j < len; j++) {
					min[j] = Math.min(arr[j], min[j - 1]);
					sum += min[j];
				}
				sum = (int) (sum % (Math.pow(10, 9) + 7));
			}
			return sum;
		}

		/**
		 * 动态规划，滚动数组，空间复杂度：O(N)，时间复杂度：O(log2N)
		 */
		public int sumSubarrayMins1(int[] arr) {
			int len = arr.length;
			int[] min = new int[len];
			int sum = 0;
			for (int i = 0; i < len; i++) {
				min[i] = arr[i];
				sum += min[i];
				for (int j = i + 1; j < len; j++) {
					min[j] = Math.min(arr[j], min[j - 1]);
					sum += min[j];
				}
				sum = (int) (sum % (Math.pow(10, 9) + 7));
			}
			return sum;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */