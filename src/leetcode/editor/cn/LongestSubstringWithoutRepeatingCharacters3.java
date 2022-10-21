/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 8012 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 无重复字符的最长子串
 * @id 3
 * @Slug longest-substring-without-repeating-characters
 * @date 2022-08-18 14:26:14
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters3 question = new LongestSubstringWithoutRepeatingCharacters3();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chArr = s.toCharArray();
            int start = 0, end = 0, max = 0;
            // 统计每个字符出现的次数
            int[] count = new int[128];
            // 遍历字符
            for (int i = 0; i < chArr.length; i++) {
                char c = chArr[i];
                // 如果已经出现过了
                if (count[c] == 1) {
                    // 将前指针对应的计数-1
                    count[chArr[start]]--;
                    // 前指针后移
                    start++;
                    // 位置保持不变
                    i--;
                    continue;
                }
                // 没有出现过，后指针后移
                end++;
                // 计数 +1
                count[c]++;
                // 统计最大出现次数
                max = Math.max(max, end - start);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

滑动窗口

4:20 秒

> 2022/08/18 14:32:56
解答成功:
	执行耗时:1 ms,击败了100.00% 的Java用户
	内存消耗:41.2 MB,击败了88.87% 的Java用户

 */