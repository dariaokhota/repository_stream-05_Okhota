package smoke;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static homework1.Homework1.*;

@Tag("smoke")
public class ThreeTests {

    @BeforeEach
    void eachTestStart() {
        System.out.println("=================");
        System.out.println("Test method start");
    }

    // boolean isEven(int n) — запустить метод один раз со случайным числом от 1 до 100;
    @Test
    void testOneResult() {
        int randomNumber = new Random().nextInt(1,100);
        System.out.println("Random number: " + randomNumber);
        System.out.println("Result: " + isEven(randomNumber));
    }

    //String checkAccess(int age) — запустить метод 20 раз со случайными числами от 0 до 99;
    @RepeatedTest(20)
    void testTwoResult() {
        int randomAge = new Random().nextInt(0,99);
        System.out.println("Random age: " + randomAge);
        System.out.println("Result: " + checkAccess(randomAge));
    }

    //String getGrade(int score) — запустить метод в параметризованных тестах с массивом случайных чисел от 0 до 100.
    static Stream<Arguments> randomScores() {
        Random random = new Random();
        int numberOfTests = 5;
        return IntStream.range(0,numberOfTests).mapToObj(i -> Arguments.of(random.nextInt(0,100)));
    }

    @ParameterizedTest
    @MethodSource("randomScores")
    void testThreeResult(int score) {
        String result = getGrade(score);
        System.out.println(score + " score(s)");
        System.out.println("Grade: " + result);
    }

    @AfterEach
    void eachTestEnd() {
        System.out.println("Test method end");
        System.out.println("=================");
    }
}
