/**
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数为n
 * 1 <= n <= 10⁴
 * 0 <= Node.val < n
 * Node.val 中所有值 不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值 不同
 * <p>
 * <p>
 * Related Topics 数组 哈希表 链表 👍 131 👎 0
 */


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ziker
 * @title 链表组件
 * @id 817
 * @Slug linked-list-components
 * @date 2022-10-12 10:02:01
 */
public class LinkedListComponents817 {
	public static void main(String[] args) {
		LinkedListComponents817 question = new LinkedListComponents817();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int numComponents(ListNode head, int[] nums) {
			HashSet<Integer> numSet = new HashSet<>(new ArrayList<>());
			for (int num : nums) {
				numSet.add(num);
			}
			int count = 0;
			// 上一个数是否在 nums 中存在
			boolean oldSign = false;
			while (head != null) {
				// 当前数是否在链表中存在
				boolean sign = numSet.contains(head.val);
				// 当前数在 nums 中存在 且 上一个数在nums 中不存在才会出现分段
				if (sign && !oldSign) {
					count++;
				}
				oldSign = sign;
				head = head.next;
			}
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
/*

> 2022/10/12 10:17:44
解答成功:
	执行耗时:5 ms,击败了94.25% 的Java用户
	内存消耗:41.8 MB,击败了87.54% 的Java用户

> 2022/10/12 10:27:16
解答成功:
	执行耗时:5 ms,击败了94.25% 的Java用户
	内存消耗:41.6 MB,击败了96.49% 的Java用户


 */