
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 424 👎 0


package org.xbp.algorithm.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：螺旋矩阵
 class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new LinkedList<>();
        if (matrix==null||matrix.length==0) return  result;
        int m=matrix.length,n=matrix[0].length;
        //确定上下左右四条边的位置
        int up=0, down=m-1,left=0,right=n-1;
        while (true){
            for (int i=left;i<=right;i++){//从左往右遍历，如果遍历完成条件就是上下边界重合
                result.add(matrix[up][i]);
                if (++up>down) break;
            }
            for (int i=up;i<=down;i++){
                result.add(matrix[i][right]);
                if (--right>left) break;
            }
            for (int i=right;i>=left;i--){
                result.add(matrix[down][i]);
                if (--down<up) break;
            }
            for (int i=down;i>=up;i--) {
                result.add(matrix[i][left]);
                if (++left>right) break;
            }
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}