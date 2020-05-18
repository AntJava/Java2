package ru.gb.jtwo.blesson.online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class ArrayBuilder {
    protected static String[][] Builder(String str) throws MyArraySizeException{
        String[][] arr2d = new String[4][4];
        String[] arr = str.split("(\\\\n|\n)");
        if (str.isEmpty()) throw new MyArraySizeException("Пустая строка!");
        if (arr.length != 4) throw new MyArraySizeException("Должно быть строк в матрице: 4, у вас: " + arr.length);
        for (int i = 0; i < arr.length; i++){
            String [] array = arr[i].split(" ");
            if (array.length != 4) throw new MyArraySizeException("В строке " + (i+1) + " вместо 4 столбцов , у вас: " + array.length);
            for (int j = 0; j < array.length; j++){
                arr2d[i][j] = array[j];
            }
        }
        System.out.println("Получаем массив: " + Arrays.deepToString(arr2d));
        return arr2d;
    }
}

class ArrayMath {
    protected static double Sum(String[][] arr) throws MyArrayDataException {
        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+") == false)
                    throw new MyArrayDataException("Не числовое значение в ячейке ", new int[] {(i+1), (j+1)});
                sum += Double.parseDouble(arr[i][j]);
            }
        }
        return (sum/2);
    }
}

class MyArraySizeException extends Exception {

    public MyArraySizeException(String message){
        super(message);
    }
}

class MyArrayDataException extends Exception {

    private int[] array;

    public int[] getArr() {
        return array;
    }

    public MyArrayDataException(String message, int[] arr) {
        super(message);
        array = arr;
    }
}

class HomeWork2 {
    private static String Reader(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку вида '10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0' или default для стандартной:");
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (str.equals("default")) {
            str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        }
        return str;
    }

    public static void main(String[] args){

        ArrayBuilder ab = new ArrayBuilder();
        ArrayMath arraySum = new ArrayMath();
        while(true) {
            try {
                System.out.println("Сумма чисел массива: " + arraySum.Sum(ab.Builder(Reader())));
                break;
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.print(e.getMessage());
                System.out.println(Arrays.toString(e.getArr()));
            }
        }
    }
}