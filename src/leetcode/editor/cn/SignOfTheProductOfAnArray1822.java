/**
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * <p>
 * <p>
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 54 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 数组元素积的符号
 * @id 1822
 * @Slug sign-of-the-product-of-an-array
 * @date 2022-10-27 09:59:37
 */
public class SignOfTheProductOfAnArray1822 {
	public static void main(String[] args) {
		SignOfTheProductOfAnArray1822 question = new SignOfTheProductOfAnArray1822();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int arraySign(int[] nums) {
			int flag = 1;
			for (int num : nums) {
				if (num == 0) {
					return 0;
				}
				flag = num < 0 ? -flag : flag;
			}

			return flag;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/27 10:04:16
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41.1 MB,击败了35.42% 的Java用户

 */