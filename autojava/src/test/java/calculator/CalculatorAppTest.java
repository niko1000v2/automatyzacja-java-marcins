package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorAppTest {

    @Test
    public void addTwoPositiveIntegers() {

        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        int sumaInt = kalkulatorek.add(3, 4);
        //assert
        assertEquals(7, sumaInt, "Sprawdź, że dodawanie liczb całkowitych działa");

    }

    @Test

    public void addTwoPositive() {

        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        double sumaDouble = kalkulatorek.add(1.2, 2.4);
        //assert
        assertEquals(3.6, sumaDouble,0.0000001, "Sprzawdź, że dodawanie liczb zmiennoprzecinkowych działa");
    }

    @Test
    public void divideTwoPositiveNumbers() {

        //arrange
        CalculatorApp kalkulatorek = new CalculatorApp();
        //act
        double dzielenie = kalkulatorek.divide(10.1, 5);
        //assert
        assertEquals(2.02, dzielenie, 0.001, "Sprawdź, że dzielenie liczb dodatnich działa");

    }
}