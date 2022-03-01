package com.example.desig.luckDraw;

import java.util.*;

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2022/2/23
 * description
 */
public class TwoColorBall {

    public static void main(String[] args) {
        List<Integer> redBallList = new ArrayList<>();
        List<Integer> blueBallList = new ArrayList<>();
        for (int i = 1; i <= 33; i++) {
            redBallList.add(i);
            if(i <= 16){
                blueBallList.add(i);
            }
        }
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            List<Integer> distanct = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                Integer integer = redBallList.get(random.nextInt(33));
                if(!distanct.contains(integer)){
                    distanct.add(integer);
                    stringBuilder.append(integer+",");
                }

            }
            Collections.sort(distanct, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            distanct.add(blueBallList.get(random.nextInt(16)));
            System.out.println(distanct.toString());
        }
    }
}
