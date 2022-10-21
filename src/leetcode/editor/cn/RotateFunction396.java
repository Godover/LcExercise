/**
 * 给定一个长度为 n 的整数数组 nums 。
 * <p>
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数 F 为：
 * <p>
 * <p>
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * <p>
 * <p>
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 * <p>
 * 生成的测试用例让答案符合 32 位 整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [100]
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁵
 * -100 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 数学 动态规划 👍 230 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 旋转函数
 * @id 396
 * @Slug rotate-function
 * @date 2022-08-19 15:54:34
 */
public class RotateFunction396 {
    public static void main(String[] args) {
        RotateFunction396 question = new RotateFunction396();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划
        public int maxRotateFunction(int[] nums) {
            int len = nums.length;
            int sum = 0;
            // 不带权重的总和
            int single = 0;
            for (int i = 0; i < len; i++) {
                sum += i * nums[i];
                single += nums[i];
            }
            int max = sum;
            for (int i = 1; i < len; i++) {
                // 滚动更新 sum 值，前一轮的总和加上单次不带权重的和，减伤第一个为0值的数字*n轮，因为原来在最后又 n-1轮，加上single里面多一个，所以有 n 个
                sum = single + sum - nums[len - i] * len;
                max = Math.max(max, sum);
            }
            return max;
        }

        // 滑动窗口 前缀和
//        public int maxRotateFunction(int[] nums) {
//            return 0;
//        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/08/19 16:34:47
解答成功:
	执行耗时:4 ms,击败了61.59% 的Java用户
	内存消耗:53.2 MB,击败了69.82% 的Java用户

 */