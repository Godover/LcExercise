/**
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * <p>
 * <p>
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * <p>
 * <p>
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都
 * 出现了两次。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 94 👎 0
 */


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author ziker
 * @title 最大相等频率
 * @id 1224
 * @Slug maximum-equal-frequency
 * @date 2022-08-18 10:14:00
 */
public class MaximumEqualFrequency1224 {
    public static void main(String[] args) {
        MaximumEqualFrequency1224 question = new MaximumEqualFrequency1224();
        question.run();
    }

    public void run() {
        Solution solution = new Solution();
        System.out.println(solution.maxEqualFreq(new int[]{2, 2, 2, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            int res = 0;
            // 统计每个数出现的次数
            HashMap<Integer, Integer> n2c = new HashMap<>();
            // 统计同一个出现次数的数有多少个
            HashMap<Integer, Integer> c2n = new HashMap<>();
            // 最多的出现次数
            int max = 0;

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                // 让这个数在原来统计的位置-1，因为这次统计了整个结果会变
                if (n2c.containsKey(num)) {
                    c2n.put(n2c.get(num), c2n.get(n2c.get(num)) - 1);
                }
                // 统计出现的次数
                n2c.put(num, n2c.getOrDefault(num, 0) + 1);
                // 出现次数的个数
                c2n.put(n2c.get(num), c2n.getOrDefault(n2c.get(num), 0) + 1);
                // 计算最大出现次数的个数
                max = Math.max(max, n2c.get(num));

                int curLen = i + 1;

                // 次数都为1  [1,2,3,4,5,6,7]
                if (max == 1) res = curLen;

                // 只有一个数出现了一次，其余的数出现次数一致
                if (c2n.get(max) * max + 1 == curLen) res = curLen;

                // 最大数只比其他数多出现一次  [1,1,2,2,3,3,3]
                // (c2n.getOrDefault(max - 1, 0) + 1) ： 因为后面单独+1一个数，所以原来出现max次数的那个被我们拿走了一个
                // 现在还有max-1, [1,1,2,2,3,3,3] 拿走了一个3，现在还有两个三，和1,2出现的次数一致，需要统计到1,2里面去，所以需要+1
                if ((max - 1) * (c2n.getOrDefault(max - 1, 0) + 1) + 1 == curLen) res = curLen;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/*

Hash表

> 2022/08/18 14:10:28
解答成功:
	执行耗时:83 ms,击败了16.67% 的Java用户
	内存消耗:49 MB,击败了92.22% 的Java用户

 */