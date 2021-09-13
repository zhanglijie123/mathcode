package exerciseOne.矩阵;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/1 0001 21:14
 * 给定一个元素为非负整数的二维数组matrix，
 * 每行和每列都是从小到大有序的。 再给定一个非负整数aim，请判断aim是否在matrix中。
 * 比如  1 3 9 10
 *      2 4 20 21
 *      6 5 21 29
 *      9 6 22 50
 *      查找 aim=9是否在此二维数组中
 *
 *     如果采用一般遍历方式时间复杂度O（N*M）
 *     可以从右上角10出发，如果aim<10就往左走否则往下走，如此循环找到返回下标或者true.否则返回-1或者false.这样的时间复杂度O（M+N）
 */
public class FindAimOfRelateSortTwoWeiArr {
    public static void main(String[] args) {
        int[][] marix = new int[][]{
            {1, 3, 9, 10 },
            {2, 4 ,20, 21},
            {6 ,5, 21, 29},
            {9, 6, 22, 50}
        };
        int aim = 9;
       boolean  isEsixt = getIsExist(marix,aim);
        System.out.println(isEsixt);
    }

    private static boolean getIsExist(int[][] marix, int aim) {
        int N = marix.length;
        int M = marix[0].length;
        int i =0;
        int j = M-1;
        while(j>=0 && i<N){
            if(marix[i][j] == aim){
                System.out.println(i+">>"+j);
                return  true;
            }else if(marix[i][j]<aim){
                i++;
            }else if(marix[i][j]>aim){
                j--;
            }
        }
        return false;
    }
}
