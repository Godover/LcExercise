/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [1, 10⁴] 之间。
 * 1 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 129 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 层数最深叶子节点的和
 * @id 1302
 * @Slug deepest-leaves-sum
 * @date 2022-08-17 20:23:59
 */
public class DeepestLeavesSum1302 {
    public static void main(String[] args) {
        DeepestLeavesSum1302 question = new DeepestLeavesSum1302();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxLevel = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            sum = root.val;
            sum(root.left, 0);
            sum(root.right, 0);
            return sum;
        }

        public void sum(TreeNode r, int level) {
            if (r == null) {
                return;
            }
            // 如果后面遍历的子树长度大于了前面算过的树，前面的树结果清0
            if (level > maxLevel) {
                sum = 0;
            }
            maxLevel = Math.max(maxLevel, level);
            sum(r.left, level + 1);
            sum(r.right, level + 1);

            // 只算最大深度的树的叶子，不算其他叶子节点，放在最后算也是让遍历到树叶子节点才开始计算
            if (level == maxLevel) {
                sum += r.val;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
/*

dfs

空间复杂度：O(1)
时间复杂度：O(N)

> 2022/08/17 20:47:27
解答成功:
	执行耗时:2 ms,击败了69.28% 的Java用户
	内存消耗:44.1 MB,击败了23.01% 的Java用户

 */