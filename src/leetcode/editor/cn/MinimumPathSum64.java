/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 1320 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 最小路径和
 * @id 64
 * @Slug minimum-path-sum
 * @date 2022-08-19 16:36:59
 */
public class MinimumPathSum64 {
    public static void main(String[] args) {
        MinimumPathSum64 question = new MinimumPathSum64();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int width = grid[0].length;
            int height = grid.length;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                    if (j == 0 && i != 0) grid[i][j] += grid[i - 1][j];
                    if (i > 0 && j > 0) grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
            return grid[height - 1][width - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

动态规划

> 2022/08/19 16:50:22
解答成功:
	执行耗时:3 ms,击败了18.06% 的Java用户
	内存消耗:44.2 MB,击败了34.35% 的Java用户

> 2022/08/19 16:51:35
解答成功:
	执行耗时:2 ms,击败了94.40% 的Java用户
	内存消耗:43.7 MB,击败了93.52% 的Java用户
 */