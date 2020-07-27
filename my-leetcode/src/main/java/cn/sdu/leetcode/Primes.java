package cn.sdu.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 质数
 *
 * @author icatzfd
 * Created on 2020/7/20 11:14.
 */
public class Primes {

    //判断是否为质数
    public boolean isPrimes(int n){

        for(int i=2;i*i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //小于n的所有质数个数
    public int countPrimes(int n){
        if(n<=2){
            return 0;
        }
        boolean[] isPrim=new boolean[n];
        Arrays.fill(isPrim,true);
        for(int i=2;i<n;i++){
            if(isPrim[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrim[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(isPrim[i]){
                count++;
            }
        }
        return count;

    }
}
