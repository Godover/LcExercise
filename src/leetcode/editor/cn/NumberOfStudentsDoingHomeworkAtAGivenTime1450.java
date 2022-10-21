/**
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
 * <p>
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
 * <p>
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[
 * i]]（含）的学生人数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * 输出：1
 * 解释：一共有 3 名学生。
 * 第一名学生在时间 1 开始写作业，并于时间 3 完成作业，在时间 4 没有处于做作业的状态。
 * 第二名学生在时间 2 开始写作业，并于时间 2 完成作业，在时间 4 没有处于做作业的状态。
 * 第三名学生在时间 3 开始写作业，预计于时间 7 完成作业，这是是唯一一名在时间 4 时正在做作业的学生。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：startTime = [4], endTime = [4], queryTime = 4
 * 输出：1
 * 解释：在查询时间只有一名学生在做作业。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：startTime = [4], endTime = [4], queryTime = 5
 * 输出：0
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * 输出：0
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10],
 * queryTime = 5
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <= queryTime <= 1000
 * <p>
 * <p>
 * Related Topics 数组 👍 43 👎 0
 */


package leetcode.editor.cn;

/**
 * @title 在既定时间做作业的学生人数
 * @id 1450
 * @Slug number-of-students-doing-homework-at-a-given-time
 * @author ziker
 * @date 2022-08-19 09:55:25
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime1450 {
    public static void main(String[] args) {
        NumberOfStudentsDoingHomeworkAtAGivenTime1450 question = new NumberOfStudentsDoingHomeworkAtAGivenTime1450();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int count = 0;
            for (int i = 0; i < startTime.length; i++) {
                if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

00:02:27


> 2022/08/19 10:04:12
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.7 MB,击败了28.34% 的Java用户

一次遍历,O(n)时间复杂度

 */