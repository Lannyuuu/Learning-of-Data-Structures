import java.util.*;
//杨辉三角
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//每一行第一个元素和最后一个元素是1
//其余的：[i][j] = [i-1][j] + [i-1][j-1]
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listall = new ArrayList<>();
        //第一行[1]
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        listall.add(list1);

        for (int i = 1; i < numRows; i++) {
            //每一行第一个元素是1
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            //中间元素

            List<Integer> prelist = listall.get(i-1);
            for (int j = 1; j < i; j++) {
                int p1 = prelist.get(j);
                int p2 = prelist.get(j-1);
                int sum = p1 + p2;
                tmp.add(sum);
            }
            //每一行最后一个元素是1
            tmp.add(1);

            listall.add(tmp);
        }
        return listall;
    }
}
public class L_118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ret = solution.generate(5);
        // 输出杨辉三角
        System.out.println(ret);
    }
}
