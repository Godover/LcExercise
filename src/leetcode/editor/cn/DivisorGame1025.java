/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * <p>
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * <p>
 * <p>
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * <p>
 * <p>
 * Related Topics 脑筋急转弯 数学 动态规划 博弈 👍 364 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 除数博弈
 * @id 1025
 * @Slug divisor-game
 * @date 2022-08-19 15:02:57
 */
public class DivisorGame1025 {
    public static void main(String[] args) {
        DivisorGame1025 question = new DivisorGame1025();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.divisorGame(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean divisorGame(int n) {
            boolean[] dp = new boolean[n + 1];
            dp[1] = false;
            for (int i = 2; i <= n; i++) {
                for (int j = i / 2; j >= 1; j--) {
                    // j 能够被 i整除 并且 前面i-j的位置一定会输，那这次一定会赢
                    // 核心就是前面任一 i-j 的位置有一个会输那么这次就一定赢，必选这个让他输的数
                    if (i % j == 0 && !dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划

> 2022/08/19 15:39:44
解答成功:
	执行耗时:9 ms,击败了5.46% 的Java用户
	内存消耗:40.7 MB,击败了5.38% 的Java用户


> 2022/08/19 15:42:10
解答成功:
	执行耗时:3 ms,击败了26.55% 的Java用户
	内存消耗:38.1 MB,击败了68.82% 的Java用户

 */