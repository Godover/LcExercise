/**
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。 餐厅里三明治的数量与学生的数
 * 量相同。所有三明治都放在一个 栈 里，每一轮：
 * <p>
 * <p>
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * <p>
 * <p>
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * <p>
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i 个三明治的类型（i = 0 是栈的顶部），
 * students[j] 是初始队列里第 j 名学生对三明治的喜好（j = 0 是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 * 解释：
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] 要么是 0 ，要么是 1 。
 * students[i] 要么是 0 ，要么是 1 。
 * <p>
 * <p>
 * Related Topics 栈 队列 数组 模拟 👍 80 👎 0
 */


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ziker
 * @title 无法吃午餐的学生数量
 * @id 1700
 * @Slug number-of-students-unable-to-eat-lunch
 * @date 2022-10-19 10:07:17
 */
public class NumberOfStudentsUnableToEatLunch1700 {
	public static void main(String[] args) {
		NumberOfStudentsUnableToEatLunch1700 question = new NumberOfStudentsUnableToEatLunch1700();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();
		solution.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// 暴力模拟
		public int countStudents1(int[] students, int[] sandwiches) {
			Queue<Integer> queue = new LinkedList<>();
			for (int student : students) {
				queue.add(student);
			}
			int stackIndex = 0;
			while (true) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					if (!queue.isEmpty() && queue.peek() == sandwiches[stackIndex]) {
						queue.poll();
						stackIndex++;
						break;
					}
					queue.add(queue.poll());
				}
				// 没有学生被移除，则都不喜欢了，退出
				if (queue.size() == size) {
					return size;
				}
			}
		}

		// 面包去匹配学生
		public int countStudents(int[] students, int[] sandwiches) {
			int[] cn = new int[2];
            // 先对喜欢两种食物的学生计数
			for (int student : students) {
				cn[student]++;
			}
            // 顺序发面包，如果面包发不出去了，就是没人喜欢这个面包了
			for (int i = 0; i < sandwiches.length; i++) {
				if (--cn[sandwiches[i]] == -1) {
					return sandwiches.length - i;
				}
			}
			return 0;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/19 10:26:07
解答成功:
	执行耗时:2 ms,击败了26.00% 的Java用户
	内存消耗:39.9 MB,击败了8.46% 的Java用户

> 2022/10/19 10:31:41
解答成功:
	执行耗时:1 ms,击败了46.51% 的Java用户
	内存消耗:39.2 MB,击败了75.69% 的Java用户

 */