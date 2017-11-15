package com.company;

import java.util.Scanner;

public class Max {
    private void count(int[] a) {
        int[] arr = new int[(a.length+1)/2];
        arr[0] = a[0] + a[a.length - 1];
        int max = arr[0];
        for(int i = 1; i < a.length/2; i++){
            arr[i] = a[i] + a[a.length - i - 1];
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input n");
        int n = in.nextInt();
        int a[] = new int[n];
        System.out.println("Input array");
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        new Max().count(a);
    }
}
