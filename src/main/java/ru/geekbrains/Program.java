package ru.geekbrains;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //System.out.printf("����� �������: %d\n", task1(new int[] {1, 2, 3}));
        //task2();
        //task3();
        //task4();
        //task5();

        // ��� ������� ������ ������ ��� ������ divideArrays � subtractArrays

        int[] arr1 = {1000, 300, 800};
        int[] arr2 = {10, 30, 400};
        System.out.println("������ ������:" + Arrays.toString(arr1));
        System.out.println("������ ������:" + Arrays.toString(arr2));

        try {
            int[] quotient = divideArrays(arr1, arr2);
            System.out.println("������� ��������� ��������:" + Arrays.toString(quotient));
        } catch (RuntimeException e) {
            System.err.println("��������� ������: " + e.getMessage());
        }

        int[] subtract = subtractArrays(arr1, arr2);
        System.out.println("�������� ��������� ��������:" + Arrays.toString(subtract));
    }

    /**
     ���������� �����, ����������� � �������� ��������� ������������� ������.
     ���� ����� ������� ������ ���������� ��������� ��������, ����� ����������
     -1, � �������� ���� ������, ����� - ����� �������.
     */
    static int task1(int[] arr){
        if (arr == null)
            return -2;
        if (arr.length == 0)
            return -1;
        return arr.length;
    }

    /**
     ���������� �����, ����������� � �������� ��������� ������������� ������ � ��������� ��������.
     ����� ���� � ������� �������� �������� � ���������� ��� ������. ��� ����, ��������:
     1. ���� ����� ������� ������ ���������� ��������� ��������, ����� ���������� -1, � �������� ���� ������.
     2. ���� ������� ������� �� ������, ����� ������ -2 � �������� ���� ������.
     3. ���� ������ ������� ������ null, ����� ������ -3
     4. ���������� ���� �������� �������������� �������� � ������� ��������������� ���� ������.
     �������� �����, � ������� ���������� �������������� � �������������.
     �� ����, ���� ����� �������� ������� ����� � ������������, ������� ������,
     ���������� ������������ �������� � ������� �������� ��������� ������������.
     ��������, ���� �������� -2, ������������ ��������� ���������: �������� ������� �� ������.
     */

    static void task2(){


        while (true){
            System.out.print("������� �������� ��� ������: ");
            if (scanner.hasNextInt()){
                int searchNumber = scanner.nextInt();
                int[] array = new int[random.nextInt(5) + 1];
                if (random.nextInt(3) == 0)
                    array = null;
                if (array != null){
                    for (int i = 0; i < array.length; i++){
                        array[i] = random.nextInt(10);
                        System.out.printf("%d\t", array[i]);
                    }
                    System.out.println();
                }

                int codeResult = processArray(array, searchNumber);
                switch (codeResult){
                    case -1 -> System.out.println("����� ������� ����� ���� ��������.");
                    case -2 -> System.out.println("������� �� ������.");
                    case -3 -> System.out.println("������ ����������� ������������������.");
                    default -> {
                        System.out.println("������ ������� ���������. ���������� ������ ����������.");
                        System.out.printf("������� ������ �� �������: %d\n", codeResult);
                        return;
                    }
                }

            }
            else{
                System.out.println("����� ��� ������ ������� �����������.\n��������� ������� �����.");
                scanner.nextLine();
            }
        }

    }

    static int processArray(int[] arr, int searchArray){
        if (arr == null)
            return -3; // ������ ����������� ������������������
        if (arr.length < 3)
            return -1; // ����� ������� ����� ���� ��������
        Arrays.sort(arr);
        for (int e: arr){
            System.out.printf("%d\t", e);
        }
        System.out.println();
        int searchResult = Arrays.binarySearch(arr, searchArray);
        if (searchResult < 0)
            return -2; // ������� �� ������

        return searchResult;
    }

    /**
     * ���������� �����, ����������� � �������� ��������� ������������� ��������� ������.
     *     ���������� ��������� � ������� ����� ��������� ����� �������.
     *     ��� ���� ����������� �� ����� 2 �����������: ����� ����� �������� ������ � ����������� ���������
     *     (���-�� ����� = ���-�� ��������), � � ������ ������ ����� ������ ������ �������� 0 ��� 1.
     *     ���� ���������� ���� �� �������, ����� ������ ������� RuntimeException � ���������� �� ������.
     */

    static void task3(){
        for (int i = 0; i < 5; i++){
            processArray(generateArray());
        }
    }

    static void processArray(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length != arr.length)
                throw new RuntimeException("������������ ����������� �������.");
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] != 0 && arr[i][j] != 1)
                    throw new RuntimeException(String.format("������������ �������� �������� ������� �� ������� [%d][%d]", i, j));
                else
                    sum += arr[i][j];

        System.out.printf("����� ��������� �������: %d\n", sum);
    }

    /**
     * ����� ��������� ���������� ������� �����
     * @return ��������� ������
     */
    static int[][] generateArray(){
        int[][] arr = new int[random.nextInt(4, 6)][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = random.nextInt(2);
                if (random.nextInt(50) == 0)
                    arr[i][j] = 2; // ���������� ������
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    /**
     ���������� �����, ����������� � �������� ��������� ������������� ��������� ������.
     ���������� ��������� � ������� ����� ��������� ����� �������.
     ��� ���� ����������� �� ����� 2 �����������: ����� ����� �������� ������ � ����������� ���������
     (���-�� ����� = ���-�� ��������), � � ������ ������ ����� ������ ������ �������� 0 ��� 1.
     ���� ���������� ���� �� �������, ����� ������ ������� ��� ������.
     ��������� ������ ��������� ���������� ��� ������ � ������� ��������������� ��������� ������������.
     �������� ����� ������� ��������� ���������� � ����������.
     */

    static void task4(){
        for (int i = 0; i < 5; i++) {
            int errCode = processArrayV2(generateArray());
            switch (errCode){
                case -1 -> System.out.println("������������ ������ �������.");
                case -2 -> System.out.println("������������ �������� �������.");
                default -> {
                    System.out.printf("����� ��������� �������: %d\n", errCode);
                }
            }
        }
    }

    static int processArrayV2(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length != arr.length)
                return -1;
                //throw new RuntimeException("������������ ����������� �������.");
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] != 0 && arr[i][j] != 1)
                    return -2;
                    //throw new RuntimeException(String.format("������������ �������� �������� ������� �� ������� [%d][%d]", i, j));
                else
                    sum += arr[i][j];

        //System.out.printf("����� ��������� �������: %d\n", sum);
        return sum;
    }

    /**
    ���������� �����, ����������� � �������� ���������� ��� ������������� �������,
     � ������������ ����� ������, ������ ������� �������� ����� ����� ��������� ����
     �������� �������� � ��� �� ������.
     ���� ����� �������� �� �����, ���������� ���-�� ���������� ������������.
    */

    static void task5(){

        try {
            int[] res = getSumArray(new int[]{1, -2, 3, 0}, new int[] {4, 3, 1, 0, 1});
            for (int e: res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("����� ������� �������: %d\n����� ������� �������: %d\n",
                    e.getLength1(), e.getLength2());
        }

    }

    static int[] getSumArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("��� ������� ������ ������������.");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("���-�� ��������� ������� ������ ���� ����������.", arr1.length, arr2.length);

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }

    public static int[] subtractArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("����� �������� �� �����");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static int[] divideArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("����� �������� �� �����");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("������� �� ����");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

}

class CustomArraySizeException extends RuntimeException{

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }

}
