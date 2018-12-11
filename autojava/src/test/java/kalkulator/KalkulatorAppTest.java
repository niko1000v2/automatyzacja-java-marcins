package kalkulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorAppTest {

    @Test
    public void addTwoPositiveIntegers() {

        //arrange
        KalkulatorApp kalkulatorek = new KalkulatorApp();
        //act
        int sumaInt = kalkulatorek.add(3, 4);
        //assert
        assertEquals(7, sumaInt, "Sprawdź, że dodawanie liczb całkowitych działa");

    }

    @Test

    public void addTwoPositive() {

        //arrange
        KalkulatorApp kalkulatorek = new KalkulatorApp();
        //act
        double sumaDouble = kalkulatorek.add(1.2, 2.4);
        //assert
        assertEquals(3.6, sumaDouble,0.0000001, "Sprzawdź, że dodawanie liczb zmiennoprzecinkowych działa");
    }

    @Test
    public void divideTwoPositiveNumbers() {

        //arrange
        KalkulatorApp kalkulatorek = new KalkulatorApp();
        //act
        double dzielenie = kalkulatorek.divide(10.1, 5);
        //assert
        assertEquals(2.02, dzielenie, 0.001, "Sprawdź, że dzielenie liczb dodatnich działa");

    }
}