package leetcode.editor.cn;

/**
 * @author ziker
 * @title 可被三整除的偶数的平均值
 * @id 6220
 * @Slug
 * @date 2022年10月30日12:20:08
 */
public class AverageValue6220 {
	public static void main(String[] args) {
		AverageValue6220 question = new AverageValue6220();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int averageValue(int[] nums) {
			int sum = 0;
			int count = 0;
			for (int num : nums) {
				if (num % 2 == 0 && num % 3 == 0) {
					sum += num;
					count++;
				}
			}
			return count == 0 ? 0 : sum / count;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}