/**
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词
 * searchWord 是否为句子 sentence 中任意单词的前缀。
 * <p>
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个单词
 * 的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * <p>
 * 字符串 s 的 前缀 是 s 的任何前导连续子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：sentence = "i love eating burger", searchWord = "burg"
 * 输出：4
 * 解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：sentence = "this problem is an easy problem", searchWord = "pro"
 * 输出：2
 * 解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：sentence = "i am tired", searchWord = "you"
 * 输出：-1
 * 解释："you" 不是句子中任何单词的前缀。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * <p>
 * <p>
 * Related Topics 字符串 字符串匹配 👍 70 👎 0
 */


package leetcode.editor.cn;

/**
 * @author ziker
 * @title 检查单词是否为句中其他单词的前缀
 * @id 1455
 * @Slug check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
 * @date 2022-08-21 22:24:57
 */
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455 {
    public static void main(String[] args) {
        CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455 question = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence1455();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] arr = sentence.split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/08/21 22:26:58
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.1 MB,击败了77.70% 的Java用户

 */