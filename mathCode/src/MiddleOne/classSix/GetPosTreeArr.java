package MiddleOne.classSix;

import java.util.HashMap;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/6/2 0002 15:12
 * 已知一棵二叉树中没有重复节点，并且给定了这棵树的中序遍历数组和先序遍历
 * 数组，返回后序遍历数组。
 * 比如给定：
 * int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
 * int[] in = { 4, 2, 5, 1, 6, 3, 7 };
 * 返回：
 * {4,5,2,6,7,3,1}
 * 前提：数组中数字不能重复
 */
public class GetPosTreeArr {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pos = getPos(pre,in);
        for (int po : pos) {
            System.out.print(po );
        }
    }

    private static int[] getPos(int[] pre, int[] in) {
        if(pre==null || in==null || pre.length==0 || in.length==0){
            return null;
        }
        int N = pre.length;
        int[] pos = new int[N];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i=0;i<N;i++) {
            map.put(in[i],i);
        }
        set(pre,in,pos,0,N-1,0,N-1,0,N-1,map);
        return pos;
    }

    private static void set(int[] pre, int[] in, int[] pos, int fpre, int lpre, int fin, int lin, int fpos, int lpos,HashMap<Integer,Integer> map) {
        if(fpre > lpre){
            return;
        }
        //只有一个元素
        if(fpre==lpre){
            pos[fpos] = pre[fpre];
            return;
        }
        //普通情况往下走
        pos[lpos] = pre[fpre];
        int find = map.get(pre[fpre]);
        //以lpos下标位头左边设置 //find-fin指的是左的规模
        set(pre,in,pos,fpre+1,fpre+find-fin,fin,find-1,fpos,fpos+find-fin-1,map);
        //以lpos下标位头右边设置
        set(pre,in,pos,fpre+find-fin+1,lpre,find+1,lin,fpos+find-fin,lpos-1,map);
    }
}
