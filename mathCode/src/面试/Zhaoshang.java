package 面试;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author zhanglijie
 * @version 1.0
 * @since 1.1.0 2021/8/20 0020 18:45
 */
public class Zhaoshang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n<=23 && n>=1){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(scanner.nextInt());
            }
            getResNum(list);
        }else{
            System.out.println(0);
        }
    }

    private static void getResNum(ArrayList<Integer> list) {
        Collections.sort(list);

        int size = list.size();
        if(list.get(size-1)<=23 &&list.get(size-1)>=1){
            int count =0;
            for(int i=0;i<size;i++){
                for(int j=i+1;j<size;j++){
                    if((list.get(i)+list.get(j))==24){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }else{
            System.out.println(0);
        }
    }

}
