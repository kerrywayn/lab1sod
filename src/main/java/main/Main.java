package main;

import java.util.Random;

public class Main {
    int k1 = 0;
    int k2 = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        int[] array = createArray(100000);
        int count = countNumsInRange(array, 2, 4);
        System.out.println("count = " + count);
        int index1002 = indexOf(array, 1002);
        System.out.println("index1002 = " + index1002);
        long start = System.currentTimeMillis();
        sort(array);
        long finish = System.currentTimeMillis();
        System.out.println("Time = " + (finish-start));
        int[] arr2 = createArray(200000);
        start = System.currentTimeMillis();
        sort(arr2);
        finish = System.currentTimeMillis();
        System.out.println("Time = " + (finish-start));
        int index1002int = findBinary(array, 1002);
        System.out.println("index1002int = " + index1002int);
        System.out.println("k1 = " + k1);
        System.out.println("k2 = " + k2);
    }

    public int[] createArray(int count){
        Random random = new Random();
        return random.ints(count, 0, 100000+2000).toArray();
    }

    public int countNumsInRange(int[] array, int start, int end){
        int count = 0;
        for (int a: array){
            if (a >=start && a <= end) {
                count++;
            }
        }
        return count;
    }

    public int indexOf(int[] array, int number){
        for (int i = 0; i < array.length; i++){
            k1++;
            if (array[i]==number){
                return i;
            }
        }
        return - 1;
    }

    public void sort(int[] array){
        int N = array.length;
        for (int i = N-1; i >= 0; i--){
            for (int j=0; j < i; j++){
                if (array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public int findBinary(int[] array, int num){
        int left = 0;
        int right = array.length-1;
        while (true){
            if (left > right){
                return -1;
            }
            k2++;
            int mid = (left + right)/2;
            if (array[mid] == num){
                return mid;
            }
            if (array[mid] > num){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
    }
}
