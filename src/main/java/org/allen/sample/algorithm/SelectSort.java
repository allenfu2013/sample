package org.allen.sample.algorithm;

/**
 * 选择排序也是一种简单直观的排序算法。
 * 它的工作原理很容易理解：初始时在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectSort {

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if (index > i) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 9, 7, 10, 8};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
