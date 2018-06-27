package org.allen.sample.algorithm;

/**
 * 快速排序使用分治策略(Divide and Conquer)来把一个序列分为两个子序列。步骤为：
 * 1. 从序列中挑出一个元素，作为"基准"(pivot).
 * 2. 把所有比基准值小的元素放在基准前面，所有比基准值大的元素放在基准的后面（相同的数可以到任一边），这个称为分区(partition)操作。
 * 3. 对每个分区递归地进行步骤1~2，递归的结束条件是序列的大小是0或1，这时整体已经被排好序了。
 */
public class QuickSort {

    public static void quickSort(int[] a, int m, int n) {
        if (m > n) return;

        int i = m;
        int j = n;
        int temp = a[m];

        while (i != j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            while (i < j && a[i] <= temp) {
                i++;
            }

            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        a[m] = a[i];
        a[i] = temp;

        quickSort(a, m, i - 1);
        quickSort(a, i + 1, n);
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 9, 7, 10, 8};
        quickSort(a, 0, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
