/**
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 * <p>
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：target = [7], arr = [7]
 * 输出：true
 * 解释：arr 不需要做任何翻转已经与 target 相等。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：target = [3,7,9], arr = [3,7,11]
 * 输出：false
 * 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 👍 54 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 通过翻转子数组使两个数组相等
 * @id 1460
 * @Slug make-two-arrays-equal-by-reversing-sub-arrays
 * @date 2022-08-24 09:55:01
 */
public class MakeTwoArraysEqualByReversingSubArrays1460 {
    public static void main(String[] args) {
        MakeTwoArraysEqualByReversingSubArrays1460 question = new MakeTwoArraysEqualByReversingSubArrays1460();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] targetArr = new int[1001];
            for (int i : target) {
                targetArr[i]++;
            }
            for (int i : arr) {
                if (targetArr[i]-- == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/08/24 09:59:08
解答成功:
	执行耗时:8 ms,击败了11.09% 的Java用户
	内存消耗:41.2 MB,击败了51.18% 的Java用户


> 2022/08/24 10:04:50
解答成功:
	执行耗时:6 ms,击败了19.81% 的Java用户
	内存消耗:41.7 MB,击败了5.43% 的Java用户

> 2022/08/24 10:30:39
解答成功:
	执行耗时:1 ms,击败了99.76% 的Java用户
	内存消耗:42 MB,击败了5.43% 的Java用户

 */