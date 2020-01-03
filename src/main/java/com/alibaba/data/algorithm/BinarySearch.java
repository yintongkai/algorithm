package com.alibaba.data.algorithm;

import java.util.Arrays;

/**
 * @program: StructureAndAlgorithm
 * @description: none
 * @author: tongkai yin
 * @create: 2020/01/03 14:25
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int start, int end, int hkey){
        if (start > end)
            return -1;
        int mid =(start+end) /2;
        if (arr[mid] > hkey)
            return binarySearch(arr, start, mid - 1, hkey);
        if (arr[mid] < hkey)
            return binarySearch(arr, mid + 1, end, hkey);
        return mid;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int temp[] = new int[]{45, 34, 56, 1, 76, 4, 84,67,36,12,73,39};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int data[]=sortAlgorithm.quickSort(temp, 0, temp.length - 1);
        System.out.println(Arrays.toString(data));
        int index=binarySearch.binarySearch(data, 0, data.length - 1, 73);
        System.out.println(index);
    }
}