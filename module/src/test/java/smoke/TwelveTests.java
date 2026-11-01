package smoke;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static homework1.Homework1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class TwelveTests {
    // Test 1 - isEven
    @Test
    void isEvenTest() {
        Random random = new Random();
        int n = random.nextInt(-10,11);
        boolean expectedResult = (n % 2 == 0);
        boolean actualResult = isEven(n);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Число: " + n);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 2 - checkAccess
    @Test
    void checkAccessTest() {
        Random random = new Random();
        int age = random.nextInt(0,101);
        String expectedResult;
        if (age > 18) {
            expectedResult = "Allowed";
        }
        else {
            expectedResult = "Denied";
        }
        String actualResult = checkAccess(age);

        if (actualResult.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Возраст: " + age);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 3 - isPositive
    @Test
    void isPositiveTest() {
        Random random = new Random();
        int n = random.nextInt(-10,11);
        boolean expectedResult = (n >= 0);
        boolean actualResult = isPositive(n);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Число: " + n);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 4 - getGrade
    @Test
    void getGradeTest() {
        Random random = new Random();
        int score = random.nextInt(0,101);
        String expectedResult;
        if (score >= 0 && score <= 20) {
            expectedResult = "E";
        }
        else if (score >= 21 && score <= 40) {
            expectedResult = "D";
        }
        else if (score >= 41 && score <= 60) {
            expectedResult = "C";
        }
        else if (score >= 61 && score <= 80) {
            expectedResult = "B";
        }
        else if (score >= 81 && score <= 100) {
            expectedResult = "A";
        }
        else {
            expectedResult = "Error";
        }
        String actualResult = getGrade(score);

        if (actualResult.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Балл: " + score);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 5 - blastOff
    @RepeatedTest(10)
    void blastOffTest() {
        Random random = new Random();
        int start = random.nextInt(1,11);
        String expectedResult = "";
        String result = "";
        for (int i = start; i >= 1; i--) {
            result = result + i + " ";
        }
        expectedResult = result + "Поехали!";
        String actualResult = blastOff(start);

        if (actualResult.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Точка отсчета: " + start);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);

    }

    // Test 6 - sumToN
    @RepeatedTest(5)
    void sumToNTest() {
        Random random = new Random();
        int n = random.nextInt(1,11);
        int expectedResult;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        expectedResult = sum;
        int actualResult = sumToN(n);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Сумма до числа: " + n);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }


    // Test 7 - hasBug
    static Stream<Arguments> words() {
        return Stream.of(
                Arguments.of(false, new String[]{"Не Bug", "Дефект"}),
                Arguments.of(true, new String[]{"Bug"}),
                Arguments.of(false, new String[]{"Ошибка", "Расхождение"})
        );
    }

    @ParameterizedTest
    @MethodSource("words")
    void hasBugTest(boolean expectedResult, String[] messages) {
        boolean actualResult = hasBug(messages);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Проверяемые строки: " + Arrays.toString(messages));
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 8 - getEvenInRange
    @RepeatedTest(5)
    void getEvenInRangeTest() {
        Random random = new Random();
        int start = random.nextInt(-10,11);
        int end = random.nextInt(-10,11);

        String expectedResult;
        if (start > end) {
            expectedResult = "";
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    result.append(i).append(" ");
                }
            }
            expectedResult = result.toString().trim();
        }
                String actualResult = getEvenInRange(start, end);

        if (actualResult.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("От: " + start + " до: " + end);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 9 - findMax
    static Stream<Arguments> digits() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 5, 4, 3}),
                Arguments.of(-2, new int[]{-50, -2, -99}),
                Arguments.of(25, new int[]{25})
        );
    }
    @ParameterizedTest
    @MethodSource("digits")
    void findMaxTest(int expectedResult, int[] arr) {
        int actualResult = findMax(arr);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Массив чисел: " + Arrays.toString(arr));
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 10 - reverse
    static Stream<Arguments> wordsArray() {
        return Stream.of(
                Arguments.of(new String[]{"Яблоко", "Дыня", "Арбуз"}, new String[]{"Арбуз", "Дыня", "Яблоко"}),
                Arguments.of(new String[]{"delta", "gamma", "beta", "alpha"}, new String[]{"alpha", "beta", "gamma", "delta"}),
                Arguments.of(new String[]{"10"}, new String[]{"10"}),
                Arguments.of(new String[]{}, new String[]{})
        );
    }
    @ParameterizedTest
    @MethodSource("wordsArray")
    void reverseTest(String[] expectedResult, String[] arr) {
        String[] actualResult = reverse(arr);
        if (Arrays.equals(actualResult, expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Изначальный массив: " + Arrays.toString(arr));
        System.out.println("Ожидаемый результат: " + Arrays.toString(expectedResult));
        System.out.println("Фактический результат: " + Arrays.toString(actualResult));
    }

    // Test 11 - calcAverage
    @RepeatedTest(7)
    void calcAverageTest() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int size = random.nextInt(3, 6);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(1, 21);
            list.add(num);
            sum += num;
        }
        int expectedResult = sum / list.size();
        int actualResult = calcAverage(list);

        if (actualResult == expectedResult) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Список чисел: " + list);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }

    // Test 12 - removeSpecificName
    static Stream<Arguments> names() {
        return Stream.of(
                Arguments.of(List.of("Саша", "Маша", "Дима"), "Дима", List.of("Саша", "Маша")),
                Arguments.of(List.of("Автомобиль", "Самолет", "Колено"), "Колено", List.of("Автомобиль", "Самолет")),
                Arguments.of(List.of(), "Жанна", List.of())
        );
    }
    @ParameterizedTest
    @MethodSource("names")
    void removeSpecificNameTest(List<String> fullList, String nameToRemove, List<String> expectedResult) {
        List<String> actualResult = removeSpecificName(fullList, nameToRemove);
        if (actualResult.equals(expectedResult)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Изначальный список: " + fullList);
        System.out.println("Убрать лишнее: " + nameToRemove);
        System.out.println("Ожидаемый результат: " + expectedResult);
        System.out.println("Фактический результат: " + actualResult);
    }
}
