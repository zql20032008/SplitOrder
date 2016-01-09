package com.bruce.global.buy.test;

public class TestBit {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 5 };

        int b[] = { 0, 1, 0, 1 };
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += a[i] * b[i];
        }
        System.out.println(sum);
    }

}
