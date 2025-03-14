package com.bridgelabz.lambdaexpression;


import java.util.Arrays;

class Outer<T> {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        double[] b = {5,6,7,8};

        for(int i=0 ; i<a.length; i++){
            b[i] = a[i];

        }

        System.out.println(Arrays.toString(b));

    }
}