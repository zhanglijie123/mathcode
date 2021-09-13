package MiddleOne.classFive;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/5/8 0008 15:39
 * 给定一个数组arr，如果通过调整可以做到arr中任意两个相邻的数字相乘是4的倍数， 返回true；如果不能返回false
 *
 * 首先提取 数组arr钟 奇数的个数 a   2的倍数的个数 b    4的倍数的个数  c
 *  如果b==0:   那么a和c排列这样最好 奇4奇4奇4....奇即可    如果a==1,c>=1;如果a>1,c>=a-1
 *  如果b>1：  那么22224奇4奇4....奇即可   a==0,c==0;a==1,c>=1;a>1,c>=a ===>c>=a
 *  如果b==1:  那么24奇4奇4....奇即可   a==0,c>=1;a!=0,c>=a
 */
public class IsFourArrByAdjust {
    public static void main(String[] args) {
        int[] arr = new int[]{ 2,4,1,1,4};
        System.out.println(nearMultiple4Times(arr));

    }
    public static boolean nearMultiple4Times(int[] arr) {
        int fourTimes = 0; // 是4的倍数的数有多少个
        int twoTimes = 0; // 是偶数但不是4的倍数的数有多少个
        int odd = 0; // 奇数有多少个
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) != 0) {
                odd++;
            } else {
                if (arr[i] % 4 == 0) {
                    fourTimes++;
                } else {
                    twoTimes++;
                }
            }
        }
        if(twoTimes==0){
            if(odd==1 ){
                if(fourTimes>=1) {
                    return true;
                }
            }else{
                if(fourTimes>=odd-1){
                    return true;
                }
            }
        }else{
            if(twoTimes==1 &&fourTimes>=odd){
                    return true;
            }else if(twoTimes>1 && fourTimes>=odd){
                return true;
            }
        }
        return false;

    }
}
