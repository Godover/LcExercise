/**
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。 

 例如： 

 
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

 

 示例 1： 

 
输入：columnNumber = 1
输出："A"
 

 示例 2： 

 
输入：columnNumber = 28
输出："AB"
 

 示例 3： 

 
输入：columnNumber = 701
输出："ZY"
 

 示例 4： 

 
输入：columnNumber = 2147483647
输出："FXSHRXW"
 

 

 提示： 

 
 1 <= columnNumber <= 2³¹ - 1 
 

 Related Topics 数学 字符串 👍 550 👎 0

*/


package leetcode.editor.cn;

/**
 * @title Excel表列名称
 * @id 168
 * @Slug excel-sheet-column-title
 * @author ziker
 * @date 2022-08-17 20:22:07
 */
public final class ExcelSheetColumnTitle168 {
    public static void main(String[] args){
        ExcelSheetColumnTitle168 question = new ExcelSheetColumnTitle168();
        question.run();
    }
    
    public void run(){
        Solution solution = new Solution();

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        // 进制转换算法
        while (columnNumber > 0) {
            int x = columnNumber % 26;
            x = x == 0 ? 26 : x;
            columnNumber = (columnNumber - x) / 26;
            s.insert(0, (char) (64 + x));
        }
        return s.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}
/*

数学

> 2022/08/17 20:23:39
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.6 MB,击败了60.62% 的Java用户

*/