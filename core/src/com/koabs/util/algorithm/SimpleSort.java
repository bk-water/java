package com.koabs.util.algorithm;

/**
 * Author: koabs
 * 7/2/17.
 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
 * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
 */
public class SimpleSort {

    static Integer[] sort(Integer[] list) {
        Integer min, temp;
        for (int i=0;i<list.length;i++) {
             min = i;
            for (int j=i+1;j<list.length;j++){
                if (list[min]>list[j])min=j;
            }

            if (min!= i) {
                temp = list[i];
                list[i]=list[min];
                list[min] = temp;
            }

            for (Integer v:list) {
                System.out.print(v+" ");
            }
            System.out.println("--");
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] list = {9,2,28,99,34,56,12};
        SimpleSort.sort(list);
    }
}
