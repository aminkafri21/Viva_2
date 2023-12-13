package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1;
        int n2;
        System.out.print("Enter size of the first array: ");
        n1 = sc.nextInt();
        System.out.print("Enter size of the second array: ");
        n2 = sc.nextInt();
        double[] Array1 = new double[n1];
        double[] Array2 = new double[n2];
        System.out.println("Enter the element of the first array");
        for(int i=0;i < n1;i++) {
            System.out.print("Array" + "[" + i + "]: ");
            Array1[i] = sc.nextDouble();
        }
        System.out.println("Enter the element of the second array");
        for(int i=0;i < n2;i++) {
            System.out.print("Array" + "[" + i + "]: ");
            Array2[i] = sc.nextDouble();
        }



        double median = getMedian(Array1, Array2);

        System.out.printf("%.3f\n", median);

    }

    static double getMedian(double[] arr1, double[] arr2) {
        bubbleSort(arr1);
        bubbleSort(arr2);
        double[] arr3 = mergedArray(arr1, arr2);
        int idx;
        if(arr3.length % 2 == 0) {
            return (arr3[arr3.length / 2] + arr3[((arr3.length / 2) - 1)]) / 2;
        }else {
            idx = arr3.length / 2;
        }

        return arr3[idx];
    }

    static double[] mergedArray(double[] arr1, double[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        double[] arr3 = new double[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while(i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }

    static void bubbleSort(double[] arr) {
        for(int i=0;i < arr.length;i++){
            for(int j=0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    


}
