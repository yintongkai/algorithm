package com.alibaba.data.algorithm;

/**
 * @program: StructureAndAlgorithm
 * @description: 面值5元，2元，1元，5角，2角，1角，5分，2分，1分，输入M，求组合数
 * @author: tongkai yin
 * @create: 2020/01/03 14:44
 */
public class CalculateMoney {
    public int count(int datas, int M) {
        if (datas <= 1) {
            return 1;
        } else {
            int currentNum = M / datas;
            int count = currentNum;
            for (int i = 0; i < currentNum; i++) {
                int sum = count(getNext(datas), M - (i * datas));
                count = sum+count;
            }
            return count;
        }
    }


    public int getNext(int current) {
        int[] datas = {100,50, 20, 10, 5, 2, 1};
        for (int i = 0; i < datas.length; i++) {
            if (current == datas[i]) {
                return datas[i + 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CalculateMoney calculateMoney = new CalculateMoney();
        int a=calculateMoney.count(100, 100);
        System.out.println(a);
    }
}