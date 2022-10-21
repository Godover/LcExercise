/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * 0 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 1963 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 跳跃游戏
 * @id 55
 * @Slug jump-game
 * @date 2022-08-18 14:36:04
 */
public class JumpGame55 {
    public static void main(String[] args) {
        JumpGame55 question = new JumpGame55();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 0, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int[] dp = new int[nums.length];
            // 当前还有几步可以走
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 下一步没步数了并且还能走的步数也为0了
                if (dp[i] == 0 && dp[i - 1] == 0) {
                    return false;
                }
                // 贪心，取当前能走的步数和剩余能走的步数中的最大步数
                dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*
22:30

动态规划
> 2022/08/18 15:01:37
解答成功:
	执行耗时:4 ms,击败了17.03% 的Java用户
	内存消耗:41.7 MB,击败了81.85% 的Java用户

 */