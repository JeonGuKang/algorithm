package com.example.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


class AlgorithmApplicationTests {

    @Test
    void 내림차순() {
        long value = 118372L;
        final int[] ints = Long.toString(value).chars().map(x -> x - '0').toArray();
        String result = Arrays.stream(Arrays.stream(ints).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray())
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        System.out.println(result);
    }

    @Test
    void contextLoads() {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.printAll();
    }


    @Test
    void 하샤드수(int x) {
        final int[] ints = Integer.toString(x).chars().map(item -> item - '0').toArray();
        int sum = 0;
        for(int i : ints) {
            sum += i;
        }
        boolean answer = x % sum == 0;
    }

    @Test
    long 두정수사이의합(int a, int b) {
        if(a == b) return a;
        long sum = 0;
        for(int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }

    @Test
    int 콜라츠추측(int num) {
        if(num == 1) return 0;
        long intToLong = num;
        int count = 0;
        while (intToLong != 1) {
            if(intToLong % 2 == 0) {
                intToLong /= 2;
            } else {
                intToLong *= 3;
                intToLong +=1;
            }
            count ++;
        }

        if(count >= 500.0) {
            return -1;
        } else {
            return count;
        }
    }


    @Test
    void 서울에서김서방찾기() {
        String[] seoul = {"Jane", "Kim"};
        int index = Arrays.stream(seoul).collect(Collectors.toList()).indexOf("Kim");
        System.out.println();
    }

    @Test
    int[] 나누어떨어지는숫자배열(int[] arr, int divisor) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if(i % divisor == 0) {
                result.add(i);
            }
        }
        if(result.size() == 0) return new int[]{-1};
        result.sort(Integer::compareTo);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    String 핸드폰번호가리기(String phone_number) {
        return "*".repeat(phone_number.length() - 4) + phone_number.substring(phone_number.length() - 4);
    }

    @Test
    void 시소짝궁() {
        int[] weights = {100,180,360,100,270};
        int result = 0;
        for(int i = 0; i < weights.length -2; i++) {
            for(int j = 1; j < weights.length -1; j++) {
                int gcd = getGCD(weights[i], weights[j]);
                int lcm = (weights[i] * weights[j]) / gcd;
                int minValue = Math.min(weights[i], weights[j]);
                if((minValue * 4) >= lcm) {
                    System.out.println(lcm);
                    result++;
                }
            }
        }
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }

}
