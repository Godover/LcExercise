/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * <p>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * <p>
 * <p>
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 👍 1228 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 解码方法
 * @id 91
 * @Slug decode-ways
 * @date 2022-08-18 15:11:49
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        DecodeWays91 question = new DecodeWays91();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
//        System.out.println(solution.numDecodings("2611055971756562"));
//        System.out.println(solution.numDecodings("1212121"));
//        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("12121"));
        // n:新增     c:拼接    f:无效
        // 1
        // n1,2  c12
        // n1,2,1   n12,1   c1,21   c120f
        // n1,2,1,2     n12,1,2     n1,21,2    c1,2,12     c12,12      c1,212f
        // 1:新增一个元素=上次有效元素总和   2:拼接一个元素=上次为1的个数加上上次为2的个数并且新增不能大于6
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            int len = s.length();
            char[] cs = (" " + s).toCharArray();
            int[] dp = new int[len + 1];
            dp[0] = 1;
            for (int i = 1; i <= len; i++) {
                int newNum = cs[i] - '0';
                // 能够新增
                if (newNum > 0) dp[i] += dp[i - 1];
                int concat = (cs[i - 1] - '0') * 10 + cs[i] - '0';
                // 能够拼接上,10<=x<=26
                if (concat >= 10 && concat <= 26) dp[i] += dp[i - 2];
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

01:50:00

动态规划

> 2022/08/18 17:02:39
解答成功:
	执行耗时:1 ms,击败了34.10% 的Java用户
	内存消耗:39.6 MB,击败了63.18% 的Java用户

 */


/*

    class Solution {
        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            // 0 本次新增个数
            // 1 本次拼接个数
            // 2 本次1,2元素个数
            int len = s.length();
            int[][] dp = new int[len][4];
            char[] chars = s.toCharArray();
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[0][2] = chars[0] == '1' ? 1 : 0;
            dp[0][3] = chars[0] == '2' ? 1 : 0;

            for (int i = 1; i < chars.length; i++) {
                char c = chars[i];
                // 新增为上一次的有效个数
                if (c != '0') {
                    dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                    if (c == '1') {
                        dp[i][2] = dp[i][0];
                    }
                    if (c == '2') {
                        dp[i][3] = dp[i][0];
                    }
                }
                // 直接拼接上一次为 1  的个数
                dp[i][1] += dp[i - 1][2];
                // 条件拼接 为上一次 2 的个数
                if (c <= '6') {
                    dp[i][1] += dp[i - 1][3];
                }
            }
            return dp[len - 1][0] + dp[len - 1][1];
        }
    }

 */