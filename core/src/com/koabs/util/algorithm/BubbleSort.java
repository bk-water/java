package com.koabs.util.algorithm;

/**
 * Author: koabs
 * 7/3/17.
 * 冒泡排序
 * 要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
 */
public class BubbleSort {
    static Integer[] sort(Integer[] list) {
        Integer min, temp;
        for (int i=0;i<list.length-1;i++) {

            for (int j=0;j<list.length-i-1;j++){
                if (list[j]>list[j+1]) {
                    temp = list[j];list[j]=list[j+1];list[j+1]=temp;
                }
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
        BubbleSort.sort(list);
    }
}
