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

    @Test
    void 시저암호() {
        String s = "a B z";
        int n = 4;
        final char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        String answer = "";
        for(char item : charArray) {
            if(item == ' ') {
                stringBuilder.append(" ");
            } else {
                int charToInt = (int)item;
                if(Character.isLowerCase(item)) {
                    System.out.println((char) ((charToInt - 'a' + 26 + n) % 26 + 'a'));
                    stringBuilder.append((char) ((charToInt - 'a' + 26 + n) % 26 + 'a'));
                } else {
                    stringBuilder.append((char) ((charToInt - 'A' + 26 + n) % 26 + 'A'));
                }
            }
        }
        answer = stringBuilder.toString();
    }

    //https://school.programmers.co.kr/learn/courses/30/lessons/131705
    @Test
    void 삼총사() {
        int[] arr = {-2, 3, 0, 2, -5};
        int n = arr.length;
        int r = 3;
        // 크기가 5인 수열 arr에서 r인 3r개를 뽑은 경우를 출력한다.
        int[] combArr = new int[n]; // 뽑은 원소의 인덱스를 저장하는 배열
        doCombination(combArr, n, r, 0, 0, arr);
        System.out.println("sumResult = " + sumResult);
    }
    int sumResult = 0;
    public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
        if(r == 0) {
            // 다 뽑았을 때
            int sum = 0;
            for(int i=0; i<index; i++) {
                sum += arr[combArr[i]];
            }
            if(sum == 0) {
                sumResult++;
            }
        } else if (target == n) {
            //r개를 다 못뽑았는데 arr의 모든 원소를 다 검사했을 때, 실패 -> 아무것도 안하고 끝난다.
            return;
        } else {
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr); // (i) 원소를 뽑는 경우
            doCombination(combArr, n, r, index, target+1, arr); // (ii) 원소를 안뽑는 경우
        }
    }



    @Test
    void 최소직사각형() {
        int[][] arr = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int maxWidth = 0;
        int maxHeight = 0;
        for (int[] ints : arr) {
           if(ints[1] > ints[0]) {
               int temp = ints[0];
               ints[0] = ints[1];
               ints[1] = temp;
           }
           if(ints[0] >= maxWidth) {
               maxWidth = ints[0];
           }
            if(ints[1] >= maxHeight) {
                maxHeight = ints[1];
            }
        }

        System.out.println("result = " + (maxWidth * maxHeight));
    }
}
