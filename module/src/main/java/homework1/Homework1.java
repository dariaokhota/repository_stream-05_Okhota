package homework1;

import java.util.ArrayList;
import java.util.List;

public class Homework1 {

    //Задача 1
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    //Задача 2
    public static String checkAccess(int age) {
        if (age >= 18) {
            return "Allowed";
        }
        else {
            return "Denied";
        }
    }
    //Задача 3
    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    //Задача 4
    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        }
        else if (score >= 21 && score <= 40) {
            return "D";
        }
        else if (score >= 41 && score <= 60) {
            return "C";
        }
        else if (score >= 61 && score <= 80) {
            return "B";
        }
        else if (score >= 81 && score <= 100) {
            return "A";
        }
        else {
            return "Error";
        }
    }
    //Задача 5
    public static String blastOff(int start) {
        String result = "";
        for (int i = start; i >= 1; i--) {
            result = result + i + " ";
        }
        return result + "Поехали!";
    }

    //Задача 6
    public static int sumToN(int n) {
        if (n == 'n') {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    //Задача 7
    public static boolean hasBug(String[] messages) {
        for (String message : messages) {
            if ("Bug".equals(message)) {
                return true;
            }
        }
        return false;
    }

    //Задача 8
    public static String getEvenInRange(int start, int end){
        if (start > end) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                result.append(i).append(" ");
            }
        }
        return result.toString().trim();
    }

    //Задача 9
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //Задача 10
    public static String[] reverse(String[] arr) {
        String[] reversed = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[(arr.length - 1) - i] = arr[i];
        }
        return reversed;
    }

    //Задача 11
    public static int calcAverage(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum / list.size();
    }

    //Задача 12
    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> resultList = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return resultList;
        }
        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                resultList.add(name);
            }
        }
        return resultList;
    }
}
