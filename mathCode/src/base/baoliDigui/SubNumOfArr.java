package base.baoliDigui;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/26 0026 23:57
 */
public class SubNumOfArr {
    public static void main(String[] args) {
        SubNumOfArr test = new SubNumOfArr();
        List< List<Integer>> subsets = test.subsets(new int[] {1, 2, 3});
        for (List<Integer> s : subsets) {
            System.out.println(s);
        }
    }
    public  List<List<Integer>> subsets(int[] nums) {
        List< List<Integer>> res = new ArrayList<>();
     //   process(nums,res,0,new ArrayList<Integer>() );
        process1(nums,res,0,new ArrayList<Integer>() );

        return res;
    }

    private void process(int[] nums, List< List<Integer>> res, int i, ArrayList<Integer> integers) {
        if(nums.length == i){
            del(res,integers);
            return;
        }
        //no pick
        process(nums,res,i+1,integers);
        //pick
        Integer  temp = nums[i];
        integers.add(temp);
        process(nums,res,i+1,integers);
        integers.remove(temp);
    }
    private void process1(int[] nums, List< List<Integer>> res, int i, ArrayList<Integer> integers) {
        if(nums.length == i){
            del(res,integers);
            return;
        }
        ArrayList<Integer> temp =  cp(integers);
        temp.add(nums[i]);
        process1(nums,res,i+1,temp);//如果要就要自己开辟补干扰下面的
        //no pick
        process1(nums,res,i+1,integers);

    }

    private ArrayList<Integer> cp(ArrayList<Integer> integers) {
        ArrayList<Integer> r = new ArrayList<>();
        for (Integer integer : integers) {
            r.add(integer);
        }
        return r;
    }

    private void del( List< List<Integer>> res, ArrayList<Integer> integers) {
        List<Integer> temp = new ArrayList<>();
        for (Integer integer : integers) {
            temp.add(integer);
        }
        res.add(temp);
    }
}
