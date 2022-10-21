/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
 * "aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * <p>
 * Related Topics 双指针 字符串 动态规划 👍 717 👎 0
 */


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author ziker
 * @title 判断子序列
 * @id 392
 * @Slug is-subsequence
 * @date 2022-08-19 10:18:23
 */
public class IsSubsequence392 {
    public static void main(String[] args) {
        IsSubsequence392 question = new IsSubsequence392();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        public boolean isSubsequence1(String s, String t) {
            char[] superArr = t.toCharArray();
            char[] subArr = s.toCharArray();
            int subIndex = 0;
            for (int i = 0; i < superArr.length && subIndex < subArr.length; i++) {
                if (superArr[i] == subArr[subIndex]) {
                    subIndex++;
                }
            }
            return subIndex == subArr.length;
        }

        // 跳跃贪心法 | 动态规划
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            char[] superArr = t.toCharArray();
            char[] subArr = s.toCharArray();
            // 当前位置的下一个字符出现的位置
            int[][] dp = new int[t.length()][26];
            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
            // 子串第一个字符出现的位置
            int[] subFirstCharIndex = new int[26];
            Arrays.fill(subFirstCharIndex, -1);
            // 子串上一个字符出现的位置
            int[] subOldCharIndex = new int[26];
            for (int i = 0; i < superArr.length; i++) {
                int cIndex = superArr[i] - 'a';
                // 从上一个和自己相同的字符的位置开始，一直到自己，更新这个区间范围内这些字符到自己的位置
                for (int j = subOldCharIndex[cIndex]; j < i; j++) {
                    dp[j][cIndex] = i;
                }
                // 记录自己最后一次出现的位置
                subOldCharIndex[cIndex] = i;
                // 记录第一个自己出现的位置
                if (subFirstCharIndex[cIndex] == -1) {
                    subFirstCharIndex[cIndex] = i;
                }
            }
            int subIndex = 0;
            // 找到sub第一个字符在super中出现的第一个位置
            int superIndex = subFirstCharIndex[subArr[subIndex] - 'a'];
            while (true) {
                // 位置已经不存在了
                if (superIndex == -1) {
                    return false;
                }
                // sub索引完了
                if (++subIndex == subArr.length) {
                    break;
                }
                // 找到sub下一个字符在super中的位置
                superIndex = dp[superIndex][subArr[subIndex] - 'a'];
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

00:04:03
双指针
> 2022/08/19 10:22:36
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.5 MB,击败了57.42% 的Java用户

00:42:30
跳跃贪心法 | 动态规划
> 2022/08/19 11:15:36
解答成功:
	执行耗时:2 ms,击败了42.58% 的Java用户
	内存消耗:41.7 MB,击败了5.04% 的Java用户

 */