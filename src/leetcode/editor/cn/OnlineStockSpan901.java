/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100]
 * ,[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 * <p>
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用 10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 * <p>
 * <p>
 * Related Topics 栈 设计 数据流 单调栈 👍 219 👎 0
 */


package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author ziker
 * @title 股票价格跨度
 * @id 901
 * @Slug online-stock-span
 * @date 2022-10-21 10:08:04
 */
public class OnlineStockSpan901 {
	public static void main(String[] args) {
		OnlineStockSpan901 question = new OnlineStockSpan901();
		question.run();
	}

	public void run() {
		StockSpanner solution = new StockSpanner();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class StockSpanner {
		// 价格
		Stack<Integer> stack = new Stack<>();
		// 每天的价格跨度
		Stack<Integer> prices = new Stack<>();

		public StockSpanner() {

		}

		public int next(int price) {
			int count = 1;
			// 合并 自己到前面的自己之间的 整个下降渠道的坡度，因为后面的能找到自己一定比自己大，所以直接合并当前自己到上一个自己之间的整个坡度
			while (!stack.isEmpty() && stack.peek() <= price) {
				stack.pop();
				count += prices.pop();
			}
			stack.push(price);
			prices.push(count);
			return count;
		}
	}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/21 10:25:32
解答成功:
	执行耗时:612 ms,击败了7.37% 的Java用户
	内存消耗:49.4 MB,击败了72.51% 的Java用户

> 2022/10/21 10:27:29
解答成功:
	执行耗时:312 ms,击败了9.86% 的Java用户
	内存消耗:49.7 MB,击败了49.79% 的Java用户

> 2022/10/21 10:29:14
解答成功:
	执行耗时:176 ms,击败了11.62% 的Java用户
	内存消耗:49.5 MB,击败了62.03% 的Java用户

> 2022/10/21 11:31:10
解答成功:
	执行耗时:59 ms,击败了29.05% 的Java用户
	内存消耗:50.2 MB,击败了27.91% 的Java用户


 */