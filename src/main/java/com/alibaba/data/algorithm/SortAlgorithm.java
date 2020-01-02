package com.alibaba.data.algorithm;

import com.alibaba.data.structure.TreeNode;

import java.util.Arrays;

/**
 * @program: StructureAndAlgorithm
 * @description: none
 * @author: tongkai yin
 * @create: 2020/01/01 21:26
 */
public class SortAlgorithm {
    //冒泡排序
    public int[] BubbleSort(int [] data) {
        System.out.println("******原始数据*****");
        System.out.println(Arrays.toString(data));
        int temp;
        int count = 1;
        for (int i = 0; i <data.length-1 ; i++) {
            for (int j = 0; j <data.length-i-1 ; j++) {
                if (data[j] > data[j+1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                //System.out.println("******第"+count+"次排序后********");
                //System.out.println(Arrays.toString(data));
                count++;
            }
        }
        System.out.println("******冒泡排序后的数据*****");
        System.out.println(Arrays.toString(data));
        return data;
    }

    //希尔排序
    public int[] ShellSort(int[] data) {
        int len = data.length;
        System.out.println(len);
        //根据数组长度确定增量的最大值
        int h = 1;
        //按h*3+1得到增量序列的最大值
        while (h <= len / 3) {
            h = h * 3 + 1;
        }
        System.out.println(h);
        //进行增量查找和排序
        System.out.println("*****原始数据******");
        System.out.println(Arrays.toString(data));
        int count=1;
        while (h > 0) {
            //h=4
            for (int i = h; i <len ; i++) {//i=4
                for (int j = i; j <len ; j=j+h) {//j=8
                    //判断是否需要重新排序，如果小于k-h处的值，需要重新排序
                    if (data[j] < data[j - h]) {
                        int temp = data[j];//temp=data[8]=36
                        int m = j;//m=8 i=4
                        for (; m>=i && temp<data[m-h] ; m-=h) {
                            data[m] = data[m - h];
                        }
                        data[m] = temp;
                        System.out.println("第"+count+"次排序后");
                        System.out.println(Arrays.toString(data));
                        count++;
                    }
                }
            }
            h = (h - 1) / 3;
        }
        System.out.println(Arrays.toString(data));
        return data;
    }
    //插入排序
    public int[] insertSort(int[] data) {
        int i,j,temp;
        for ( i = 1; i <data.length ; i++) {
            temp = data[i];
            for ( j = i-1; j >=0 ; j--) {
                if (temp > data[j]) {
                    break;
                } else {
                    data[j + 1] = data[j];
                }
            }
            data[j + 1] = temp;
        }
        return data;
    }
    //选择排序
    public int[] selectSort(int data[]) {
        for (int i = 0; i <data.length ; i++) {
            int min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
        return data;
    }

    //二叉树排序
    public void treeSort(int[] datas) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = new TreeNode(datas[0]);
        for (int i = 1; i <datas.length ; i++) {
            root=treeNode.insertNode(root, new TreeNode(datas[i]));
        }
        inOrder(root);
    }
    //二叉树的中序遍历
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeftNode());
            System.out.print(root.getData()+" ");
            inOrder(root.getRightNode());
        }
    }

    //快速排序
    public int[] quickSort(int [] datas,int low,int high) {
        if (low > high) {
            return datas;
        }
        int temp = datas[low];//45
        int i = low;//0
        int j = high;//11
        while (i < j) {
            while (datas[j] >= temp && i < j) {
                j--;
            }
            while (datas[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int tem=datas[i];
                datas[i] = datas[j];
                datas[j] = tem;
            }
            System.out.println(Arrays.toString(datas)+" i="+i+" j="+j);
        }
        datas[low] = datas[i];
        datas[i] = temp;
        System.out.println(Arrays.toString(datas)+" i="+i+" j="+j);
        System.out.println("**********************");
        quickSort(datas, low, j - 1);
        quickSort(datas, j + 1, high);
        return datas;
    }

    //归并排序

    public static void mergeSort(int[] array,int L,int R) {
        if (L == R) {
            return;
        } else {
            //取中间的数，进行拆分
            int M = (L + R) / 2;
            //左边的数不断进行拆分
            mergeSort(array, L, M);
            //右边的数不断拆分
            mergeSort(array, M + 1, R);
            //合并
            merge(array, L, M +1, R);
        }
    }

        /**
         * 合并数组
         * @param array
         * @param L 指向数组的第一个元素
         * @param M 指向数组分隔的元素
         * @param R 指向数组最后的元素
         */
        public static void merge(int[] array, int L, int M, int R){
            //左边数组的大小
            System.out.println("L="+L+" M="+(M-1)+" R="+R);
            int[] leftArray = new int[M - L];
            //右边数组的大小
            int[] rightArray = new int[R - M + 1];
            //往两个数组中填充数据
            for (int i = L; i < M; i++) {
                leftArray[i - L] = array[i];
            }
            System.out.println("leftArray:"+Arrays.toString(leftArray));
            for (int i = M; i <= R; i++) {
                rightArray[i - M] = array[i];
            }
            System.out.println("rightArray:"+Arrays.toString(rightArray));

            int i = 0, j = 0;
            //array数组的第一个元素
            int k = L;

            //比较两个数组的值，哪个小，就往数组上放
            while (i < leftArray.length && j < rightArray.length) {
                //谁比较小，谁将元素放入大数组中，移动指针，继续比较下一个
                if (leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                    k++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                    k++;
                }
                System.out.println(Arrays.toString(array));
            }

            //如果左边的数组还没比较完，右边的数已经完了，那将左边的数抄到大数组中
            while (i < leftArray.length) {
                array[k] = leftArray[i];
                i++;
                k++;
                System.out.println(Arrays.toString(array));
            }
            //同理，右边数组还没比较完，左边的数已经完了
            while (j < rightArray.length) {
                array[k] = rightArray[j];
                k++;
                j++;
                System.out.println(Arrays.toString(array));
            }
        }



    public static void main(String[] args) {
        int[] data = new int[]{45, 34, 56, 1, 76, 4, 84,67,36,12,73,39};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        System.out.println(Arrays.toString(data));
        System.out.println("*********************");
        sortAlgorithm.mergeSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
}