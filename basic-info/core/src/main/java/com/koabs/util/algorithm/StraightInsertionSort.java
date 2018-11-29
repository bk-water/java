package com.koabs.util.algorithm;

/**
 * Author: koabs
 * 7/2/17.
 * 插入排序
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。即：先将序列的第1个记录看成是一个有序的子序列，
 * 然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 */
public class StraightInsertionSort {
    static Integer[] sort(Integer[] list) {
        for (int i= 1;i<list.length;i++) {
            if (list[i]<list[i-1]) {
                int j= i-1;
                int x = list[i];
                list[i]=list[i-1];
                while (j>=0&&x<list[j]) {
                    list[j+1]=list[j];
                    j--;
                }
                list[j+1]=x;

            }
            for (Integer v:list) {
                System.out.print(v+" ");
            }
            System.out.println("--");

        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] list = {9,2,34,56,12};
        StraightInsertionSort.sort(list);
    }
}
