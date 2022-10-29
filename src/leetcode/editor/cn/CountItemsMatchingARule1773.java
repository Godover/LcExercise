/**
 * 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * <p>
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * <p>
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * <p>
 * <p>
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * <p>
 * <p>
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone",
 * "gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone",
 * "gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注
 * 意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= items.length <= 10⁴
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 73 👎 0
 */


package leetcode.editor.cn;

import java.util.List;

/**
 * @author ziker
 * @title 统计匹配检索规则的物品数量
 * @id 1773
 * @Slug count-items-matching-a-rule
 * @date 2022-10-29 22:37:14
 */
public class CountItemsMatchingARule1773 {
	public static void main(String[] args) {
		CountItemsMatchingARule1773 question = new CountItemsMatchingARule1773();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
			int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
			int count = 0;
			for (List<String> item : items) {
				count += item.get(index).equals(ruleValue) ? 1 : 0;
			}
			return count;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
/*

> 2022/10/29 22:44:03
解答成功:
	执行耗时:4 ms,击败了94.33% 的Java用户
	内存消耗:46 MB,击败了70.21% 的Java用户

 */