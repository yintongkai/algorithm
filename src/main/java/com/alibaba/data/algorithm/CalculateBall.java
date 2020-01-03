package com.alibaba.data.algorithm;

import java.util.Random;

/**
 * @program: StructureAndAlgorithm
 * @description: none
 * @author: tongkai yin
 * @create: 2020/01/03 20:51
 */
public class CalculateBall {
    public int countBall=0;
    public int addOrSubtract(boolean b) {
        if (b) {
            countBall++;
        } else {
            if (countBall > 0) {
                countBall--;
            }
           // countBall--;
        }
        return countBall;
    }
    public static void main(String[] args) {
        System.out.println("计算概率1/（2的10次方）" + Math.pow(2, 10));
        CalculateBall calculateBall = new CalculateBall();
        Random random = new Random();
        int count = 0;
        while (true) {
            int countBall = calculateBall.addOrSubtract(random.nextBoolean());
            //System.out.println("盒子中球的数量是：" + countBall);
            count++;
            if (countBall == 10) {
                break;
            }
        }
        System.out.println("抛硬币的次数是：" + count);
    }
}