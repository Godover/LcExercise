package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziker
 * @title 最流行的视频创作者
 * @id 6221
 * @Slug
 * @date 2022年10月30日12:20:12
 */
public class MostPopularCreator6221 {
	public static void main(String[] args) {
		MostPopularCreator6221 question = new MostPopularCreator6221();
		question.run();
	}

	public void run() {
		Solution solution = new Solution();

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
			// 作者映射总数量
			HashMap<String, Long> nameCount = new HashMap<>();
			// 作者映射自己播放最大的视频IDIndex
			HashMap<String, Integer> nameMaxIndex = new HashMap<>();
			// 单个作者最大播放总和
			long maxCount = 0L;
			for (int i = 0; i < creators.length; i++) {
				// 维护单个作者播放总和
				String creator = creators[i];
				long count = nameCount.getOrDefault(creator, 0L) + views[i];
				nameCount.put(creator, count);
				// 维护播放最大值
				maxCount = Math.max(maxCount, count);
				// 维护单个作者播放最大的视频id
				if (nameMaxIndex.containsKey(creator)) {
					if (views[nameMaxIndex.get(creator)] < views[i]) {
						nameMaxIndex.put(creator, i);
					} else if (views[nameMaxIndex.get(creator)] == views[i] && ids[nameMaxIndex.get(creator)].compareTo(ids[i]) > 0) {
						// 如果播放量一样，则按照视频id的字典序存，取字典序在前的
						nameMaxIndex.put(creator, i);
					}
				} else {
					nameMaxIndex.put(creator, i);
				}
			}
			List<List<String>> viewList = new ArrayList<>();
			// 遍历每个作者的播放量总和
			for (Map.Entry<String, Long> entry : nameCount.entrySet()) {
				// 如果和最大播放量一致，添加进放回列表
				if (entry.getValue() == maxCount) {
					List<String> single = new ArrayList<>();
					single.add(entry.getKey());
					single.add(ids[nameMaxIndex.get(entry.getKey())]);
					viewList.add(single);
				}
			}
			return viewList;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}