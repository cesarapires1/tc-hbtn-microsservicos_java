package com.example.calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number1 + number2,
                calculator.sum(number1, number2)
        );
    }

    @Test
    public void numbersNullSumTest() {
        Double number1 = 10.0;
        Double number2 = null;
        assertThrows(NullPointerException.class, () -> {
            calculator.sum(number1, number2);
                }
        );
    }

    @Test
    void subTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number1 - number2,
                calculator.sub(number1, number2)
        );
    }

    @Test
    void divideTest() {
        Double number1 = 10.0;
        Double number2 = 20.0;
        assertEquals(number1 / number2,
                calculator.divide(number1, number2)
        );
    }

    @Test
    public void divisionByZeroTest() {
        Double number1 = 10.0;
        Double number2 = 0.0;
        assertThrows(ArithmeticException.class, () -> {
                    calculator.divide(number1, number2);
                }
        );
    }

    @Test
    void factorialTest() {
        Integer number1 = 3;
        assertEquals(6,
                calculator.factorial(number1)
        );
    }

    @Test
    void integerToBinaryTest() {
        Integer number1 = 5;
        assertEquals(101,
                calculator.integerToBinary(number1)
        );
    }

    @Test
    void integerToHexadecimalTest() {
        Integer number1 = 789456;
        assertEquals("c0bd0",
                calculator.integerToHexadecimal(number1)
        );
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2022, 02,04);
        LocalDate date2 = LocalDate.of(2022, 06,26);
        assertEquals(142,
                calculator.calculeDayBetweenDate(date1, date2)
        );
    }
}
