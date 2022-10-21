/**
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需
 * 要遵循以下规则：
 * <p>
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 res[
 * r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * <p>
 * <p>
 * 返回构造得到的矩阵 res 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 *  ["2","",""]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 *  ["","2","","","","3",""],
 *  ["","","4","","","",""]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数在范围 [1, 2¹⁰] 内
 * -99 <= Node.val <= 99
 * 树的深度在范围 [1, 10] 内
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 152 👎 0
 */


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziker
 * @title 输出二叉树
 * @id 655
 * @Slug print-binary-tree
 * @date 2022-08-22 10:11:25
 */
public class PrintBinaryTree655 {
    public static void main(String[] args) {
        PrintBinaryTree655 question = new PrintBinaryTree655();
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
        public List<List<String>> printTree(TreeNode root) {
            int height = calDepth(root);
            int m = height + 1;
            int n = (1 << (height + 1)) - 1;
            List<List<String>> res = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add("");
                }
                res.add(row);
            }
            dfs(res, root, 0, (n - 1) / 2, height);
            return res;
        }

        // 计算树高度
        public int calDepth(TreeNode root) {
            int h = 0;
            if (root.left != null) {
                h = Math.max(h, calDepth(root.left) + 1);
            }
            if (root.right != null) {
                h = Math.max(h, calDepth(root.right) + 1);
            }
            return h;
        }

        /**
         * @param res          数列
         * @param root         当前子树
         * @param level        当前层级
         * @param currentIndex 当前位置
         * @param height       树高
         */
        public void dfs(List<List<String>> res, TreeNode root, int level, int currentIndex, int height) {
            res.get(level).set(currentIndex, Integer.toString(root.val));
            if (root.left != null) {
                dfs(res, root.left, level + 1, currentIndex - (1 << (height - level - 1)), height);
            }
            if (root.right != null) {
                dfs(res, root.right, level + 1, currentIndex + (1 << (height - level - 1)), height);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*



 */