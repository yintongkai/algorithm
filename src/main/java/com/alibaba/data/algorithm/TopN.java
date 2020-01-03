package com.alibaba.data.algorithm;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @program: StructureAndAlgorithm
 * @description: none
 * @author: tongkai yin
 * @create: 2020/01/03 22:13
 */
public class TopN {
    Logger logger = Logger.getLogger(TopN.class.getName());
    //极端环境下会有问题，数组的初始化很重要
    public int[] getTopN(int[] data,int n) {
        int topn[] = new int[n];
        if (n>data.length) {
            logger.info("原始数组比输出数组小");
            return data;
        }
        for (int i = 0; i <topn.length ; i++) {
            topn[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <data.length ; i++) {
            int temp = data[i];
            int indexMin = -1;
            for (int j = 0; j <topn.length ; j++) {
                if (temp > topn[j]) {
                    temp = topn[j];
                    indexMin = j;
                }
            }
            if (indexMin != -1) {
                topn[indexMin] = data[i];
            }
            //System.out.println(Arrays.toString(topn));
        }
        return topn;
    }
    public static void main(String[] args) {
        TopN topN = new TopN();
        int data[] = new int[]{45, 34, 56, 1, 76, 4, 84,67,36,12,73,39,84,84};
        int[] topn = topN.getTopN(data, 4);
        System.out.println(Arrays.toString(topn));
    }
}