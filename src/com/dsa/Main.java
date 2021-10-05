package com.dsa;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(getBit(2, 0));
    }

    public static int getBit(int n, int pos) {
        return (n >> pos) & 1;
    }
}
